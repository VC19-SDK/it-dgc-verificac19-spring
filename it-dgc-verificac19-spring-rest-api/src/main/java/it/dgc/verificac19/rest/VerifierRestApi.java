package it.dgc.verificac19.rest;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.dgc.verificac19.data.local.Preferences;
import it.dgc.verificac19.model.CertificateSimple;
import it.dgc.verificac19.service.VerifierService;

@RestController
@RequestMapping(value = "api")
public class VerifierRestApi {

  private static final Logger LOG = LoggerFactory.getLogger(VerifierRestApi.class);

  @Autowired
  VerifierService verifierService;

  @Autowired
  Preferences preferences;

  @RequestMapping(value = "/verify-string", method = RequestMethod.GET)
  public ResponseEntity<CertificateSimple> verifyByString(@RequestParam(name = "qrCodeTxt", required = true) String qrCodeTxt) {

    if (preferences.getDateLastFetch() == null
        || !preferences.getDateLastFetch().toLocalDate().isEqual(LocalDate.now())) {
      LOG.info("Not updated");
      return ResponseEntity.ok().build();
    } else {
      CertificateSimple certificateSimple = verifierService.verify(qrCodeTxt);

      switch (certificateSimple.getCertificateStatus()) {
        case NOT_EU_DCC:
        case NOT_VALID:
        case NOT_VALID_YET:
          LOG.info("Invalid");
          break;
        case PARTIALLY_VALID:
        case VALID:
          LOG.info("Valid");
          break;
      }
      return ResponseEntity.ok(certificateSimple);
    }
  }

  @RequestMapping(value = "/verify-image", method = RequestMethod.POST)
  public String verifyByImage() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

}
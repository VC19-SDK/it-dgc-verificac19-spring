<h1 align="center">Java Spring Digital Green Certificate SDK</h1>        

# Indice
- [Contesto](#contesto)
- [Installazione](#installazione)
- [Uso](#uso)
- [Licenza](#licenza)
  - [Dettaglio licenza](#dettaglio-licenza)

# Contesto
**Attenzione, questo non e' un repository ufficiale del Ministero della Salute, ma � derivato dalle specifiche presenti in <a href="https://github.com/ministero-salute/it-dgc-verificac19-sdk-android/">ministero-salute/it-dgc-verificac19-sdk-android</a>!**

Questo repository contiene un Software Development Kit (SDK), che consente di integrare nei sistemi
le funzionalit&agrave; di verifica della Certificazione verde COVID-19, mediante 
la lettura del QR code. 

# Trattamento dati personali
Il trattamento dei dati personali svolto dalle soluzioni applicative sviluppate
a partire dalla presente SDK deve essere effettuato limitatamente alle
informazioni pertinenti e alle operazioni strettamente necessarie alla verifica
della validit&agrave; delle Certificazioni verdi COVID-19. Inoltre &egrave; fatto esplicito
divieto di conservare il codice a barre bidimensionale (QR code) delle
Certificazioni verdi COVID-19 sottoposte a verifica, nonch� di estrarre,
consultare, registrare o comunque trattare per finalit&agrave; ulteriori rispetto
a quelle previste per la verifica della Certificazione verde COVID-19 o le
informazioni rilevate dalla lettura dei QR code e le informazioni fornite in
esito ai controlli, come indicato nel DPCM 12 ottobre 2021    
 
# Installazione

Il codice sorgente � suddiviso nei due seguenti moduli maven.
1. **it-dgc-verificac19-spring-core** � una libreria JAR che fornisce un supporto alle web application Spring che hanno la necessit� di integrare nei sistemi le funzionalit� di verifica della Certificazione verde COVID-19
2. **it-dgc-verificac19-spring-rest-api** � una applicazione Spring Boot che funge da POC dell'estensione Java Spring.

###   

# Uso

Esempio:  
 
```
	//Spring Injection
	@Autowired
	VerifierService verifierService;

	public void test(){
	  String qrCodeTxt = 'HC1:6BF.......';
	  CertificateSimple certificateSimple = verifierService.verify(qrCodeTxt);
	}
```

Osservando la risposta del metodo &egrave; restituito un oggetto 
`it.dgc.verificac19.model.CertificateSimple` che contiene
il risultato della verifica.
Il data model contiene i dati relativi alla
persona, la data di nascita, il timestamp di verifica e lo stato della
verifica.

Basandosi su questi dati &egrave; possibile disegnare la UI e fornire all'operatore lo
stato della verifica del DGC.
 
    
# Licenza

## Dettaglio Licenza
La licenza per questo repository &egrave; una `Apache License 2.0`.
All'interno del file [LICENSE](./LICENSE) sono presenti le informazioni
specifiche.

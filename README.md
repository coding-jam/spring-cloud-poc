# spring-cloud-poc

POC per vedere all'opera i componenti fondamentali di Spring Cloud. 
Il progetto ha puro scopo dimostrativo e di studio, non fa praticamente niente se non esporre 2 endpoint, una delle quali chiama l'altra.

Questo progetto fa riferimento al post "[Microservizi in Java con Spring Boot e Spring Cloud](http://codingjam.it/microservizi-in-java-con-spring-boot-e-spring-cloud/)"

## Moduli

Ogni modulo Maven è un microservizio. Possiamo dividerli in due macrogruppi:

* ***infrastruttura***
    * **config-server**: server di configurazione "[Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/)". Le configurazioni risiedono in [un altro repository](https://github.com/coding-jam/spring-cloud-poc-config)
    * **eureka-server**: service registry ("[Eureka Server](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html)")
    * **zipkin-server**: server di analisi dei tempi medi delle chiamate tra servizi ("[Zipkin](https://zipkin.io/)")
* ***applicativi***
    * **customer-services**: servizi inerenti ai clienti (ha solo un endpoint di prova)
    * **order-services**: servizi inerenti agli ordini dei clienti (ha solo un endpoint di prova)
    
## Startup

Data la natura dei servizi, quelli di "infrastruttura" dovrebbero essere avviati prima di quelli applicativi. 
In particolare, è vero esclusivamente per il **config-server** perché i servizi applicativi sono configurati per *fallire subito* se non lo trovano.

## Braches

Per sperimentare ELK con Spring Cloud, il progetto ha 4 branch:

* `elk-logstash-with-grok-via-fs`: Logstash legge i file delle applicazioni direttamente da file system e li invia a ElasticSearch
* `elk-logstash-with-grok-via-filebeat`: FileBeat legge i file delle applicazioni e li invia a Logstash con il suo protocollo.
* `elk-via-filebeat`: l'applicazione scrive i log in JSON e FileBeat li legge e li invia a Logstash (che non fa altro che tipizzare alcuni campi)
* `elk-via-logstash-appender`: appender Log4j che scrive direttamente su Logstash

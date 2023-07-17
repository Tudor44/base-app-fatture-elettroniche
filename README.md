# [Italian] Sistema di Fatturazione Elettronica v0.0.1

Questo progetto è una dimostrazione per gestira la fatturazione elettronica italiana, offrendo una API basica per integrare il ciclo di fatturazione normativo con altri sistemi produttori o gestori di dati commerciali, e una dashboard di servizio. 

## Dipendenze

- Java 17
- Spring 3.x
- Angular 16
- Node.js 18.16.1  e npm 9.5.1
- SQlite 3.25.x

## Avvio 
```bash
./mvnw spring-boot:run
```

### Esempio di chiamata per generare una fattura 
```bash
POST /api/fatture
```
```json
{
  "numeroFattura": "0006",
  "dataFattura": "2023-07-15",
  "totale": 4000.00
}
```
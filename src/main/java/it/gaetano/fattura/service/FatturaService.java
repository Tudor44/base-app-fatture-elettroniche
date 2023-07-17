package it.gaetano.fattura.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.gaetano.fattura.entity.Cliente;
import it.gaetano.fattura.entity.Fattura;
import it.gaetano.fattura.entity.FatturaRequest;
import it.gaetano.fattura.repository.ClienteRepository;
import it.gaetano.fattura.repository.FatturaRepository;
import jakarta.persistence.criteria.Predicate;

@Service
public class FatturaService {
	
    private FatturaRepository fatturaRepository;

    private ClienteRepository clienteRepository;
    
    public FatturaService(FatturaRepository fatturaRepository, ClienteRepository clienteRepository) {
    	this.fatturaRepository = fatturaRepository;
    	this.clienteRepository = clienteRepository;
    }
    
    public Fattura creaFattura(FatturaRequest fatturaRequest) {
    	
    	Fattura fattura = new Fattura();
    	//RICHIESTA DI INVIO FATTURA ALLO SDI DAL CLIENTE DI DEFAULT
        String email = "gaetano.dorsi@example.com";
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepository.findByEmail(email));
        
        if (cliente.isEmpty()) {
        	//SE NON ESISTE LO CREA
            Cliente nuovoCliente = new Cliente();
            nuovoCliente.setNome("Gaetano");
            nuovoCliente.setCognome("D'Orsi");
            nuovoCliente.setTelefono("00000000");
            nuovoCliente.setCodiceDestinatario("0000000");
            nuovoCliente.setPec("gaetano.dorsi@pec.com");
            nuovoCliente.setPartitaIva("IT0123456789");
            nuovoCliente.setEmail(email);
            fattura.setCliente(clienteRepository.save((nuovoCliente)));
        }
        else
        	fattura.setCliente(cliente.get());
    	fattura.setDataFattura(LocalDate.parse(fatturaRequest.getDataFattura()));
    	fattura.setTotale(new BigDecimal(fatturaRequest.getNumeroFattura()));
    	fattura.setNumeroFattura(fatturaRequest.getNumeroFattura());
        fattura.setStato("CREATA");
    	fattura.setTipo("ATTIVA");
    	//ESEMPIO DI NOME FILE UNIVOCO DA GENERARE PER OGNI CLIENTE
    	fattura.setNomeFile("IT99999999999_A0000.XML");
    	fattura.setDataCreazione(LocalDateTime.now());
    	fattura.setDataAggiornamento(LocalDateTime.now());
    	return fatturaRepository.save(fattura);
    }

    public String getStatoFattura(Long id) throws Exception {
        Fattura fattura = fatturaRepository.findById(id)
            .orElseThrow(() -> new Exception("Fattura non trovata con id " + id));
        return fattura.getStato();
        
    }
    public Fattura getFattura(Long id) throws Exception {
        return fatturaRepository.findById(id)
            .orElseThrow(() -> new Exception("Fattura non trovata con id " + id));
    }

    public List<Fattura> getFatture(String dataInizio, String dataFine, String tipo) {
        return fatturaRepository.findAll((root, query, cb) -> {
            Predicate p = cb.conjunction();
            if (dataInizio != null && dataFine != null) {
                p = cb.and(p, cb.between(root.get("dataFattura"), LocalDate.parse(dataInizio), LocalDate.parse(dataFine)));
            }
            if (tipo != null) {
                p = cb.and(p, cb.equal(root.get("tipo"), tipo));
            }
            return p;
        });
    }
    
    
    /** 
    *
    *
    *   METODI PER COMPLETARE IL FLUSSO AD ALTO LIVELLO DELLA FATTURAZIONE ELETTRONICA.
    *
    */
    public boolean inviaFatturaASdI(Long id) {
    	
    	/*
    	 * 1. RECUPERARE LA FATTURA DA INVIARE (ATTIVA)
    	 * 2. LEGGERE IL NOME FILE E RECUPERARE IL NOME FILE SUL CANALE DI RIFERIMENTO USATO (SFTP O WEB SERVICE)
    	 * 3. SPOSTARE NELLA CARTELLA DI DESTINAZIONE PER L'SFTP, O INVIARE I DATI TRAMITE SERVIZIO WEB
    	 * 4. SE UNA DELLE DUE OPERAZIONI VA A BUON FINE (IN BASE ALLA SCELTA DEL CANARE), CAMBIARE LO STATO DELLA FATTURA DA CREATA A INVIATA.
    	 * P.S IL FLUSSO DOVREBBE CONTINUARE CON IL CONTROLLO DEGLI STATI PER OGNI FATTURA INVIATA, E AVVIARE PROCEDURE DI ROLLBACK , O DI RIPRISTINO.
    	 */
    	return false;
    }
    
    public List <Fattura> riceviFatture(String codiceDestinatario){
    	// 
    	/*
    	 * 1. CONTROLLARE SE CI SONO NUOVE FATTURE RICEVUTE (PASSIVE) "MT" ARRIVATE PER UN CLIENTE, UTILIZZANDO UN CANALE DI RIFERIMENTO (SFTP O WEB SERVICE)
    	 * 2. RECUPERARE ED ASSOCIARE IL FILE RICEVUTA "MT", PRELEVANDO LA DATA DI RICEZIONE E IL FILE XML FIRMATO 
    	 * 3. SE LA FATTURA XML E' FIRMATA, ESTRARRE L'XML DALLA FIRMA (CADES) FIRMATO E LEGGERE I DATI DA MEMORIZZARE NEL SISTEMA PER AGGIORNARE LA DASHBOARD.
    	 */
    	return null;
    			
    }
    

}


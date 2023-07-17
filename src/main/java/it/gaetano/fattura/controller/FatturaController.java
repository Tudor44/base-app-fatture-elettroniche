package it.gaetano.fattura.controller;


import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.gaetano.fattura.entity.Fattura;
import it.gaetano.fattura.entity.FatturaRequest;
import it.gaetano.fattura.entity.StatoFatturaResponse;
import it.gaetano.fattura.service.FatturaService;

@RestController
@RequestMapping("/api/fatture")
public class FatturaController {
    
    private final FatturaService fatturaService;

    public FatturaController(FatturaService fatturaService) {
        this.fatturaService = fatturaService;
    }
    
    @PostMapping
    public ResponseEntity<Fattura> creaFattura(@RequestBody FatturaRequest fattura) {
    	
    	return ResponseEntity.ok().body(fatturaService.creaFattura(fattura));
        
    }

    @GetMapping("/{id}/stato")
    public ResponseEntity<StatoFatturaResponse> getStatoFattura(@PathVariable Long id) throws Exception {
    	
            StatoFatturaResponse stato = new StatoFatturaResponse();
            stato.setId(id.toString());
            stato.setStato(fatturaService.getStatoFattura(id));
            return new ResponseEntity<>(stato, HttpStatus.CREATED);
	
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fattura> getFattura(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(fatturaService.getFattura(id), HttpStatus.OK);
    }
    


    @GetMapping
    public List<Fattura> getFatture(@RequestParam String dataInizio, 
                                    @RequestParam String dataFine, 
                                    @RequestParam String tipo) {
        return fatturaService.getFatture(dataInizio, dataFine, tipo);
    }
}

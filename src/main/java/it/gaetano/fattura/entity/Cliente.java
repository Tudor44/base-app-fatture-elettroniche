package it.gaetano.fattura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Cliente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cognome;
    
    private String codiceFiscale;
    
    private String partitaIva;
    
    private String email;

    private String telefono;
    
    private String codiceDestinatario;
    
    private String pec;
    
}
package it.gaetano.fattura.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Fattura {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String numeroFattura;
    private String nomeFile;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataFattura;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private BigDecimal totale;
    private String stato;
    private String tipo;
    private LocalDateTime dataCreazione;
    private LocalDateTime dataAggiornamento;
    

}

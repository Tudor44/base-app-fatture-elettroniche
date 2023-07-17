package it.gaetano.fattura.entity;

import lombok.Data;

@Data
public class FatturaRequest {
	
	private String numeroFattura;
	private String dataFattura;
	private String totale;
}

package it.gaetano.fattura.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import it.gaetano.fattura.entity.Cliente;
import it.gaetano.fattura.entity.Fattura;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Repository
public interface FatturaRepository extends JpaRepository<Fattura, Long>, JpaSpecificationExecutor<Fattura>  {
    
}
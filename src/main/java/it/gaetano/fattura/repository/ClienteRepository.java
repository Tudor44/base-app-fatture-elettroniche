package it.gaetano.fattura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.gaetano.fattura.entity.Cliente;
import it.gaetano.fattura.entity.Fattura;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
    Cliente findByEmail(String email);
}
package br.ifba.api.petcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

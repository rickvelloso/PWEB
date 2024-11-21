package br.ifba.api.petcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}

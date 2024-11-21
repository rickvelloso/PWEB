package br.ifba.api.petcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

package com.api.filmes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.filmes.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

    public Filme findByNome(String nome);

}

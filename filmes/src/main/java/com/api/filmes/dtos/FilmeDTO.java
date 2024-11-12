package com.api.filmes.dtos;

import com.api.filmes.entities.Filme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FilmeDTO (Long id, @NotNull(message = "O nome não pode ser nulo") @NotBlank(message = "O nome não pode ser em branco") String nome, String sinopse, String foto) {
    
    public FilmeDTO(Filme filme) {
        this(filme.getId(), filme.getNome(), filme.getSinopse(), filme.getFoto());
    }
    
}

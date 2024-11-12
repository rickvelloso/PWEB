package com.api.filmes.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.filmes.dtos.FilmeDTO;
import com.api.filmes.entities.Filme;
import com.api.filmes.repositories.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<FilmeDTO> findAll() {
        return filmeRepository.findAll().stream()
                .map(FilmeDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<FilmeDTO> findById(Long id) {
        return filmeRepository.findById(id)
                .map(FilmeDTO::new);
    }

    public FilmeDTO save(FilmeDTO dto) {
        Filme filme = new Filme(null, dto.nome(), dto.sinopse(), dto.foto());
        filme = filmeRepository.save(filme);
        return new FilmeDTO(filme);
    }

    public Optional<FilmeDTO> update(Long id, FilmeDTO dto) {
        return filmeRepository.findById(id).map(filme -> {
            filme.setNome(dto.nome());
            filme.setSinopse(dto.sinopse());
            filme.setFoto(dto.foto());
            filme = filmeRepository.save(filme);
            return new FilmeDTO(filme);
        });
    }

    public boolean delete(Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

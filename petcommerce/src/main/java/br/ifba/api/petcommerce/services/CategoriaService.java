package br.ifba.api.petcommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.ifba.api.petcommerce.dtos.request.CategoriaRequestDTO;
import br.ifba.api.petcommerce.dtos.response.CategoriaResponseDTO;
import br.ifba.api.petcommerce.entities.Categoria;
import br.ifba.api.petcommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaResponseDTO> listarTodas() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public CategoriaResponseDTO buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + id));
        return mapToResponseDTO(categoria);
    }

    public CategoriaResponseDTO salvar(CategoriaRequestDTO requestDTO) {
        Categoria categoria = mapToEntity(requestDTO);
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return mapToResponseDTO(novaCategoria);
    }

    public CategoriaResponseDTO atualizar(Long id, CategoriaRequestDTO requestDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + id));
        categoria.setNome(requestDTO.getNome());
        Categoria categoriaAtualizada = categoriaRepository.save(categoria);
        return mapToResponseDTO(categoriaAtualizada);
    }

    public void excluir(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada com o ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }

    private CategoriaResponseDTO mapToResponseDTO(Categoria categoria) {
        CategoriaResponseDTO responseDTO = new CategoriaResponseDTO();
        responseDTO.setId(categoria.getId());
        responseDTO.setNome(categoria.getNome());
        return responseDTO;
    }

    private Categoria mapToEntity(CategoriaRequestDTO requestDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(requestDTO.getNome());
        return categoria;
    }
}

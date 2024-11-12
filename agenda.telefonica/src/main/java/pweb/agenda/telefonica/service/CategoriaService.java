package pweb.agenda.telefonica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pweb.agenda.telefonica.DTOs.CategoriaDTO;
import pweb.agenda.telefonica.entities.Categoria;
import pweb.agenda.telefonica.repositories.CategoriaRepository;
import pweb.agenda.telefonica.repositories.ContatoRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    public CategoriaDTO salvarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());

        Categoria categoriaSalva = categoriaRepository.save(categoria);

        return new CategoriaDTO(categoriaSalva.getId(), categoriaSalva.getNome());
    }

    public List<CategoriaDTO> findAll(){
        return categoriaRepository.findAll().stream()
                .map(CategoriaDTO::new)
                .collect(Collectors.toList());
    }

    public boolean delete(Long id){
        if (categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

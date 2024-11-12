package pweb.agenda.telefonica.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pweb.agenda.telefonica.DTOs.ContatoDTO;
import pweb.agenda.telefonica.entities.Categoria;
import pweb.agenda.telefonica.entities.Contato;
import pweb.agenda.telefonica.repositories.CategoriaRepository;
import pweb.agenda.telefonica.repositories.ContatoRepository;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public ContatoDTO salvarContato(ContatoDTO contatoDTO) {
        Categoria categoria = categoriaRepository.findById(contatoDTO.getCategoriaId())
                             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));
        
        Contato contato = new Contato(contatoDTO, categoria);
        contato = contatoRepository.save(contato);
        
        return new ContatoDTO(contato);
    }

    public List<ContatoDTO> findAll(){
        return contatoRepository.findAll().stream()
                .map(ContatoDTO::new)
                .collect(Collectors.toList());
    }

    public boolean delete(Long id){
        if (contatoRepository.existsById(id)){
            contatoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package pweb.agenda.telefonica.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pweb.agenda.telefonica.DTOs.ContatoDTO;
import pweb.agenda.telefonica.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<ContatoDTO> salvarContato(@RequestBody ContatoDTO contatoDTO, UriComponentsBuilder uriComponentsBuilder) {
        ContatoDTO savedContato = contatoService.salvarContato(contatoDTO);
        URI uri = uriComponentsBuilder.path("/contatos/{id}").buildAndExpand(savedContato.getId()).toUri();
        return ResponseEntity.created(uri).body(savedContato);
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> findAll(){
        List<ContatoDTO> contatos = contatoService.findAll();
        return ResponseEntity.ok(contatos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (contatoService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
package pweb.agenda.telefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pweb.agenda.telefonica.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
    
}

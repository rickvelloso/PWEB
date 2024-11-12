package pweb.agenda.telefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pweb.agenda.telefonica.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

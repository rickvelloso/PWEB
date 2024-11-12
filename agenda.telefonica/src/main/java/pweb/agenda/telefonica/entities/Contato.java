package pweb.agenda.telefonica.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pweb.agenda.telefonica.DTOs.ContatoDTO;

@Entity(name="contatos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String numero;
    private String email;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;


    public Contato(ContatoDTO contatoDTO, Categoria categoria) {
    this.nome = contatoDTO.getNome();
    this.numero = contatoDTO.getNumero();
    this.email = contatoDTO.getEmail();
    this.categoria = categoria;
}
}

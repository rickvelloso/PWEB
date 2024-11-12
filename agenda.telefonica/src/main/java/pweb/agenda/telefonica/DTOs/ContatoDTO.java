package pweb.agenda.telefonica.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pweb.agenda.telefonica.entities.Contato;


@Valid
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    @NotBlank
    private String numero;  
    private String email;
    private Long categoriaId;

    public ContatoDTO(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.numero = contato.getNumero();
        this.email = contato.getEmail();
        this.categoriaId = contato.getCategoria() != null ? contato.getCategoria().getId() : null;
    }
}
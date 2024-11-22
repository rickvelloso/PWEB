package br.ifba.api.petcommerce.mappers;

import org.springframework.stereotype.Component;

import br.ifba.api.petcommerce.dtos.EnderecoDTO;
import br.ifba.api.petcommerce.dtos.request.ClienteRequestDTO;
import br.ifba.api.petcommerce.dtos.response.ClienteResponseDTO;
import br.ifba.api.petcommerce.entities.Cliente;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO requestDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(requestDTO.getNome());
        cliente.setEmail(requestDTO.getEmail());
        cliente.setTelefone(requestDTO.getTelefone());

        if (requestDTO.getEndereco() != null) {
            cliente.setEndereco(new br.ifba.api.petcommerce.entities.Endereco(
                requestDTO.getEndereco().getRua(),
                requestDTO.getEndereco().getNumero(),
                requestDTO.getEndereco().getCidade(),
                requestDTO.getEndereco().getEstado(),
                requestDTO.getEndereco().getCep()
            ));
        }

        return cliente;
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente) {
        ClienteResponseDTO responseDTO = new ClienteResponseDTO();
        responseDTO.setId(cliente.getId());
        responseDTO.setNome(cliente.getNome());
        responseDTO.setEmail(cliente.getEmail());
        responseDTO.setTelefone(cliente.getTelefone());

        if (cliente.getEndereco() != null) {
            EnderecoDTO enderecoDTO = new EnderecoDTO();
            enderecoDTO.setRua(cliente.getEndereco().getRua());
            enderecoDTO.setNumero(cliente.getEndereco().getNumero());
            enderecoDTO.setCidade(cliente.getEndereco().getCidade());
            enderecoDTO.setEstado(cliente.getEndereco().getEstado());
            enderecoDTO.setCep(cliente.getEndereco().getCep());
            responseDTO.setEndereco(enderecoDTO);
        }

        return responseDTO;
    }
}


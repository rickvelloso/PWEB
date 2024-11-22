package br.ifba.api.petcommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.ifba.api.petcommerce.dtos.request.ClienteRequestDTO;
import br.ifba.api.petcommerce.dtos.response.ClienteResponseDTO;
import br.ifba.api.petcommerce.entities.Cliente;
import br.ifba.api.petcommerce.mappers.ClienteMapper;
import br.ifba.api.petcommerce.repositories.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteResponseDTO> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente Não encontrado com o ID: " + id));
        return clienteMapper.toResponseDTO(cliente);
    }

    public ClienteResponseDTO salvar(ClienteRequestDTO requestDTO){
        Cliente cliente = clienteMapper.toEntity(requestDTO);

        Cliente novoCliente = clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(novoCliente);
    }
}

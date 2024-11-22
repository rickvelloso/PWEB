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
    private final EnderecoService enderecoService;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper, EnderecoService enderecoService) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.enderecoService = enderecoService;
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
    
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO requestDTO){
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
            
            cliente.setNome(requestDTO.getNome());
            cliente.setEmail(requestDTO.getEmail());
            cliente.setTelefone(requestDTO.getTelefone());
            if (cliente.getEndereco() != null) {
                cliente.setEndereco(enderecoService.atualizarEndereco(cliente.getEndereco(), requestDTO.getEndereco()));
            }

            Cliente clienteAtualizado = clienteRepository.save(cliente);
            return clienteMapper.toResponseDTO(clienteAtualizado);
    }

    public void excluir(Long id){
        if(!clienteRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

}

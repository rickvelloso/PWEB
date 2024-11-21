package br.ifba.api.petcommerce.dtos.response;

import java.util.List;

public class PedidoResponseDTO {
    private Long id;
    private ClienteResponseDTO cliente;
    private List<ItemPedidoResponseDTO> itens;
    private Double valorTotal;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteResponseDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponseDTO cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedidoResponseDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoResponseDTO> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

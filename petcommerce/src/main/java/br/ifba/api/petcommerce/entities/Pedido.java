package br.ifba.api.petcommerce.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens;

    private Double valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
        public Pedido() {
        	            super();
        }
        
		public Pedido(Cliente cliente, List<ItemPedido> itens, Double valorTotal, StatusPedido status) {
			this.cliente = cliente;
			this.itens = itens;
			this.valorTotal = valorTotal;
			this.status = status;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<ItemPedido> getItens() {
			return itens;
		}

		public void setItens(List<ItemPedido> itens) {
			this.itens = itens;
		}

		public Double getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(Double valorTotal) {
			this.valorTotal = valorTotal;
		}

		public StatusPedido getStatus() {
			return status;
		}

		public void setStatus(StatusPedido status) {
			this.status = status;
		}
		
		
}
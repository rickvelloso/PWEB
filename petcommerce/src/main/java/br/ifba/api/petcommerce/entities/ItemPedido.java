package br.ifba.api.petcommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "itens_pedidos")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private Integer quantidade;

    private Double precoUnitario;
    
        public ItemPedido() {
        	super();
        }
        
		public ItemPedido(Produto produto, Pedido pedido, Integer quantidade, Double precoUnitario) {
			this.produto = produto;
			this.pedido = pedido;
			this.quantidade = quantidade;
			this.precoUnitario = precoUnitario;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}

		public Double getPrecoUnitario() {
			return precoUnitario;
		}

		public void setPrecoUnitario(Double precoUnitario) {
			this.precoUnitario = precoUnitario;
		}
		
		
}
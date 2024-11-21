package br.ifba.api.petcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}

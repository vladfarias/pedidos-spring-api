package io.github.vladfarias.pedidos.repository;

import io.github.vladfarias.pedidos.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByCliente(String cliente);

    List<PedidoEntity> findByProduto(String produto);

    List<PedidoEntity> findByClienteContainingIgnoreCase(String cliente);

    List<PedidoEntity> findByProdutoContainingIgnoreCase(String produto);

    List<PedidoEntity> findByQuantidadeGreaterThan(Integer quantidade);
}
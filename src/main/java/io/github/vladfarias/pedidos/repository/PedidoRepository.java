package io.github.vladfarias.pedidos.repository;

import io.github.vladfarias.pedidos.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository
        extends JpaRepository<PedidoEntity, Long>{
}

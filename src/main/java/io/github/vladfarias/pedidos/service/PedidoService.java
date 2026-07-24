package io.github.vladfarias.pedidos.service;

import io.github.vladfarias.pedidos.entity.PedidoEntity;
import io.github.vladfarias.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoEntity> listarTodos() {
        return pedidoRepository.findAll();
    }
}
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

    public List<PedidoEntity> buscarPorCliente(String cliente) {
        return pedidoRepository.findByClienteContainingIgnoreCase(cliente);
    }

    public List<PedidoEntity> buscarPorProduto(String produto) {
        return pedidoRepository.findByProdutoContainingIgnoreCase(produto);
    }

    public List<PedidoEntity> buscarPorQuantidadeMaiorQue(Integer quantidade) {
        return pedidoRepository.findByQuantidadeGreaterThan(quantidade);
    }
}
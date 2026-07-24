package io.github.vladfarias.pedidos.service;

import io.github.vladfarias.pedidos.dto.PedidoResponseDTO;
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

    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public List<PedidoResponseDTO> buscarPorCliente(String cliente) {
        return pedidoRepository
                .findByClienteContainingIgnoreCase(cliente)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public List<PedidoResponseDTO> buscarPorProduto(String produto) {
        return pedidoRepository
                .findByProdutoContainingIgnoreCase(produto)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public List<PedidoResponseDTO> buscarPorQuantidadeMaiorQue(Integer quantidade) {
        return pedidoRepository
                .findByQuantidadeGreaterThan(quantidade)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    private PedidoResponseDTO converterParaResponse(PedidoEntity entity) {
        return new PedidoResponseDTO(
                entity.getId(),
                entity.getCliente(),
                entity.getProduto(),
                entity.getQuantidade(),
                entity.getValor()
        );
    }
}
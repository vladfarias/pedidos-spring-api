package io.github.vladfarias.pedidos.service;

import io.github.vladfarias.pedidos.dto.PedidoRequestDTO;
import io.github.vladfarias.pedidos.dto.PedidoResponseDTO;
import io.github.vladfarias.pedidos.entity.PedidoEntity;
import io.github.vladfarias.pedidos.exception.PedidoNaoEncontradoException;
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

    public PedidoResponseDTO buscarPorId(Long id) {
        PedidoEntity entity = buscarEntityPorId(id);

        return converterParaResponse(entity);
    }

    public PedidoResponseDTO criar(PedidoRequestDTO request) {
        PedidoEntity entity = new PedidoEntity();

        atualizarDados(entity, request);

        PedidoEntity pedidoSalvo = pedidoRepository.save(entity);

        return converterParaResponse(pedidoSalvo);
    }

    public PedidoResponseDTO atualizar(
            Long id,
            PedidoRequestDTO request
    ) {
        PedidoEntity entity = buscarEntityPorId(id);

        atualizarDados(entity, request);

        PedidoEntity pedidoAtualizado =
                pedidoRepository.save(entity);

        return converterParaResponse(pedidoAtualizado);
    }

    public void excluir(Long id) {
        PedidoEntity entity = buscarEntityPorId(id);

        pedidoRepository.delete(entity);
    }

    private PedidoEntity buscarEntityPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(
                        () -> new PedidoNaoEncontradoException(id)
                );
    }

    private void atualizarDados(
            PedidoEntity entity,
            PedidoRequestDTO request
    ) {
        entity.setCliente(request.cliente());
        entity.setProduto(request.produto());
        entity.setQuantidade(request.quantidade());
        entity.setValor(request.valor());
    }

    private PedidoResponseDTO converterParaResponse(
            PedidoEntity entity
    ) {
        return new PedidoResponseDTO(
                entity.getId(),
                entity.getCliente(),
                entity.getProduto(),
                entity.getQuantidade(),
                entity.getValor()
        );
    }
}
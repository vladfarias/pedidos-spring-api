package io.github.vladfarias.pedidos.service;

import io.github.vladfarias.pedidos.dto.PedidoRequestDTO;
import io.github.vladfarias.pedidos.dto.PedidoResponseDTO;
import io.github.vladfarias.pedidos.entity.PedidoEntity;
import io.github.vladfarias.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<PedidoResponseDTO> buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .map(this::converterParaResponse);
    }

    public PedidoResponseDTO criar(PedidoRequestDTO request) {
        PedidoEntity entity = new PedidoEntity();

        entity.setCliente(request.cliente());
        entity.setProduto(request.produto());
        entity.setQuantidade(request.quantidade());
        entity.setValor(request.valor());

        PedidoEntity pedidoSalvo = pedidoRepository.save(entity);

        return converterParaResponse(pedidoSalvo);
    }

    public Optional<PedidoResponseDTO> atualizar(
            Long id,
            PedidoRequestDTO request
    ) {
        return pedidoRepository.findById(id)
                .map(entity -> {
                    entity.setCliente(request.cliente());
                    entity.setProduto(request.produto());
                    entity.setQuantidade(request.quantidade());
                    entity.setValor(request.valor());

                    PedidoEntity pedidoAtualizado =
                            pedidoRepository.save(entity);

                    return converterParaResponse(pedidoAtualizado);
                });
    }

    public boolean excluir(Long id) {
        if (!pedidoRepository.existsById(id)) {
            return false;
        }

        pedidoRepository.deleteById(id);
        return true;
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
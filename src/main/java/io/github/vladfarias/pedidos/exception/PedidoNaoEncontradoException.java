package io.github.vladfarias.pedidos.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException(Long id) {
        super("Pedido não encontrado com o id: " + id);
    }
}
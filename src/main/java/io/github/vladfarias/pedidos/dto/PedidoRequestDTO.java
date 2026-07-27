package io.github.vladfarias.pedidos.dto;

import java.math.BigDecimal;

public record PedidoRequestDTO(
        String cliente,
        String produto,
        Integer quantidade,
        BigDecimal valor
) {
}
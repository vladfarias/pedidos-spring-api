package io.github.vladfarias.pedidos.dto;

import java.math.BigDecimal;

public record PedidoResponseDTO(

        Long id,

        String cliente,

        String produto,

        Integer quantidade,

        BigDecimal valor

) {
}
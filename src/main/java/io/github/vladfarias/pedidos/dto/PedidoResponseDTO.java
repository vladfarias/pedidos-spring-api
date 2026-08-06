package io.github.vladfarias.pedidos.dto;

import io.github.vladfarias.pedidos.enums.StatusPedido;

import java.math.BigDecimal;

public record PedidoResponseDTO(

        Long id,

        String cliente,

        String sku,

        String produto,

        Integer quantidade,

        BigDecimal valor,

        StatusPedido status

) {
}
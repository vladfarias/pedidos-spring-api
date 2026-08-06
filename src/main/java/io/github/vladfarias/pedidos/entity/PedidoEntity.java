package io.github.vladfarias.pedidos.entity;

import io.github.vladfarias.pedidos.enums.StatusPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente", nullable = false)
    private String cliente;

    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "produto", nullable = false)
    private String produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status;

    public PedidoEntity(
            String cliente,
            String sku,
            String produto,
            Integer quantidade,
            BigDecimal valor,
            StatusPedido status
    ) {
        this.cliente = cliente;
        this.sku = sku;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.status = status;
    }
}
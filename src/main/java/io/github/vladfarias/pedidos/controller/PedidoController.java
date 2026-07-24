package io.github.vladfarias.pedidos.controller;

import io.github.vladfarias.pedidos.dto.PedidoResponseDTO;
import io.github.vladfarias.pedidos.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoResponseDTO> listarTodos() {
        return pedidoService.listarTodos();
    }
}
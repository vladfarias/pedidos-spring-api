package io.github.vladfarias.pedidos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    @GetMapping("/pedidos")
    public String listarPedidos(){
        return "Lista de pedidos";
    }
}

package io.github.vladfarias.pedidos.controller;

import io.github.vladfarias.pedidos.dto.PedidoRequestDTO;
import io.github.vladfarias.pedidos.dto.PedidoResponseDTO;
import io.github.vladfarias.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                pedidoService.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criar(
            @Valid @RequestBody PedidoRequestDTO request
    ) {
        PedidoResponseDTO pedidoCriado =
                pedidoService.criar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedidoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody PedidoRequestDTO request
    ) {
        return ResponseEntity.ok(
                pedidoService.atualizar(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id
    ) {
        pedidoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
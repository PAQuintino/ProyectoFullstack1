package com.tienda.pedido_service.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.tienda.pedido_service.entity.Pedido;
import com.tienda.pedido_service.service.PedidoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/pedidos")
@RequiredArgsConstructor
public class pedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@Valid @RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.crearPedido(pedido));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.actualizar(id, pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

        @GetMapping("/{id}/detalle")
    public ResponseEntity<Map<String, Object>> obtenerPedidoConDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPedidoConDetalle(id));
    }

    @GetMapping("/cliente-info/{clienteId}")
    public ResponseEntity<?> obtenerCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(pedidoService.obtenerCliente(clienteId));
    }

    @GetMapping("/producto-info/{productoId}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Long productoId) {
        return ResponseEntity.ok(pedidoService.obtenerProducto(productoId));
    }
}

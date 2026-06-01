package com.tienda.pago_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tienda.pago_service.entity.Pago;
import com.tienda.pago_service.service.PagoService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/pagos")
@RequiredArgsConstructor
public class PagoController {
        private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> crearPago(@Valid @RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.crearPago(pago));
    }

    @GetMapping
    public ResponseEntity<List<Pago>> listarTodos() {
        return ResponseEntity.ok(pagoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Long id, @Valid @RequestBody Pago pago){
        return ResponseEntity.ok(pagoService.actualizar(id, pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

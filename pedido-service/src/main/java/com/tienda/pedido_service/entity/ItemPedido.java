package com.tienda.pedido_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "items_pedido")
@Data
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El pedidoId es obligatorio")
    private Long pedidoId;

    @NotNull(message = "El productoId es obligatorio")
    private Long productoId;

    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;
}

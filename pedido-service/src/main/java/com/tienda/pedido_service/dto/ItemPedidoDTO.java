package com.tienda.pedido_service.dto;

import lombok.Data;

@Data
public class ItemPedidoDTO {
    private Long id;
    private Long productoId;
    private Integer cantidad;
}

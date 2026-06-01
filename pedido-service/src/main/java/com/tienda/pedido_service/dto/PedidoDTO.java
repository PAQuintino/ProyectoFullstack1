package com.tienda.pedido_service.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;
    private Long clienteId;
    private LocalDateTime fecha;
    private List<ItemPedidoDTO> items;

  
}
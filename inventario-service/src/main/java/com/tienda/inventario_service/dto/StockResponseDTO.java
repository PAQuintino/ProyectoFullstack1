package com.tienda.inventario_service.dto;

import lombok.Data;

@Data
public class StockResponseDTO {
    private Long id;
    private Integer cantidad;
    private ProductoDTO producto; // Aquí anidamos el DTO de Producto
    private AlmacenDTO almacen;   // Aquí anidamos el DTO de Almacén
}
package com.tienda.producto_service.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
}
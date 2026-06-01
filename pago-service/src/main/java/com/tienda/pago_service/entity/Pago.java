package com.tienda.pago_service.entity;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "metodos_pago")
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El pedidoId es obligatorio")
    private Long pedidoId;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.01", message = "El monto debe ser mayor a 0")
    private BigDecimal monto;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

   
}

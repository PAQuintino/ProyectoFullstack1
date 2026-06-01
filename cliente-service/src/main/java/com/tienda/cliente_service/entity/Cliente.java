package com.tienda.cliente_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3 , message = "minimo requerido de 3 caracteres")
    private String nombre;
    
    @NotBlank
    @Size(min = 11, message = "el numero debe tener 8 digitos, más los digitos de zona (569)")
    private String telefono;

    @Email(message = "El formato del email no es válido")
    @Size(min = 10, message =  " minimo requerido de 10 caracteres")
    @NotBlank(message = "El email es obligatorio")
    private String email;
}
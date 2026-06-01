package com.tienda.cliente_service.dto;

import com.tienda.cliente_service.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    
    public Cliente toModel() {
        return new Cliente();
    }

    public static ClienteDTO fromModel(Cliente c) {
        if (c == null) return null;
        return new ClienteDTO(c.getId(), c.getNombre(), c.getEmail(), c.getTelefono());
    }
}
package com.tienda.cliente_service.service;

import com.tienda.cliente_service.entity.Cliente;
import com.tienda.cliente_service.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente) {
        log.info("Guardando cliente: {}", cliente.getNombre());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        log.info("Listando todos los clientes");
        return clienteRepository.findAll();
    }

    public Boolean existe(Long id) {
        return clienteRepository.existsById(id);
    }

    public Cliente buscarPorId(Long id) {
        log.info("Buscando cliente ID: {}", id);
        return clienteRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Cliente ID {} no encontrado", id);
                return new RuntimeException("El cliente con ese ID no existe en el sistema");
            });
    }

    public Cliente actualizar(Long id, Cliente clienteNuevo) {
        log.info("Actualizando cliente ID: {}", id);
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cliente.setNombre(clienteNuevo.getNombre());
        cliente.setEmail(clienteNuevo.getEmail());
        cliente.setTelefono(clienteNuevo.getTelefono());
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        log.info("Eliminando cliente ID: {}", id);
        clienteRepository.deleteById(id);
    }
}
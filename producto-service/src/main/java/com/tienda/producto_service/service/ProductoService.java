package com.tienda.producto_service.service;

import com.tienda.producto_service.entity.Producto;
import com.tienda.producto_service.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);
    private final ProductoRepository productoRepository;

    public Producto guardarProducto(Producto producto) {
        log.info("Guardando producto: {}", producto.getNombre());
        return productoRepository.save(producto);
    }

    public List<Producto> listarTodos() {
        log.info("Listando todos los productos");
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        log.info("Buscando producto ID: {}", id);
        return productoRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Producto ID {} no encontrado", id);
                return new RuntimeException("Producto no encontrado");
            });
    }

    public Boolean existe(Long id) {
        return productoRepository.existsById(id);
    }

    public Producto actualizar(Long id, Producto productoNuevo) {
        log.info("Actualizando producto ID: {}", id);
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(productoNuevo.getNombre());
        producto.setPrecio(productoNuevo.getPrecio());
        producto.setCategoriaId(productoNuevo.getCategoriaId());
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        log.info("Eliminando producto ID: {}", id);
        productoRepository.deleteById(id);
    }
}
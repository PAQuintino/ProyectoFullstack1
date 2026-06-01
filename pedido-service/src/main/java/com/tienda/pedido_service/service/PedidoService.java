package com.tienda.pedido_service.service;

import com.tienda.pedido_service.entity.Pedido;
import com.tienda.pedido_service.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public Pedido actualizar(Long id, Pedido pedidoNuevo){
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("pedido no encontrado"));
            pedido.setClienteId(pedidoNuevo.getClienteId());
            pedido.setProductoId(pedidoNuevo.getProductoId());
            pedido.setCantidad(pedidoNuevo.getCantidad());
            pedido.setEstado(pedidoNuevo.getEstado());
            return pedidoRepository.save(pedido);
    }

    public void eliminar(Long id){
        pedidoRepository.deleteById(id);
    }
}
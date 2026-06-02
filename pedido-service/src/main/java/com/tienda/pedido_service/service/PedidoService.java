package com.tienda.pedido_service.service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;
import com.tienda.pedido_service.entity.Pedido;
import com.tienda.pedido_service.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final WebClient.Builder webClientBuilder;

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

    public List<Pedido> buscarPorClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public List<Pedido> buscarPorEstado(String estado) {
        return pedidoRepository.findByEstado(estado);
    }

    public Object obtenerCliente(Long clienteId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/clientes/" + clienteId)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), response -> Mono.empty())
                .bodyToMono(Object.class)
                .block();
    }

    public Object obtenerProducto(Long productoId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/productos/" + productoId)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), response -> Mono.empty())
                .bodyToMono(Object.class)
                .block();
    }

    public Map<String, Object> obtenerPedidoConDetalle(Long pedidoId) {
        Pedido pedido = obtenerPorId(pedidoId);
        Object cliente = obtenerCliente(pedido.getClienteId());
        Object producto = obtenerProducto(pedido.getProductoId());
        return Map.of(
            "pedido", pedido,
            "cliente", cliente != null ? cliente : "Cliente no encontrado",
            "producto", producto != null ? producto : "Producto no encontrado"
        );
    }
}
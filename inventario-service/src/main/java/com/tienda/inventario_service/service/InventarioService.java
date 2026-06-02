package com.tienda.inventario_service.service;

import com.tienda.inventario_service.dto.ProductoDTO;
import com.tienda.inventario_service.entity.Stock;
import com.tienda.inventario_service.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final StockRepository stockRepository;
    private final WebClient.Builder webClientBuilder;

    public Stock registrarStock(Stock stock) {
    ProductoDTO producto = webClientBuilder.build()
            .get()
            .uri("http://localhost:8082/api/productos/" + stock.getProductoId())
            .retrieve()
            .onStatus(status -> status.is4xxClientError(), response -> Mono.empty())
            .bodyToMono(ProductoDTO.class)
            .block();

    if (producto == null) {
        throw new RuntimeException("Error: El producto con ID " + stock.getProductoId() + " no existe o la respuesta fue inválida.");
    }

    return stockRepository.save(stock);
}
    public Stock actualizar(Long id, Stock stockNuevo){
        Stock stock = stockRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Stock no encontrado"));
        stock.setProductoId(stockNuevo.getProductoId());
        stock.setCantidad(stockNuevo.getCantidad());
        stock.setAlmacenId(stock.getAlmacenId());
        return stockRepository.save(stock);
    }
    
    public void eliminar(long id){
        stockRepository.deleteById(id);
    }

    public List<Stock> buscarPorAlmacenId(Long almacenId) {
        return stockRepository.findByAlmacenId(almacenId);
    }

    public List<Stock> buscarPorCantidadMinima(Integer cantidad) {
        return stockRepository.findByCantidadGreaterThan(cantidad);
    }

}
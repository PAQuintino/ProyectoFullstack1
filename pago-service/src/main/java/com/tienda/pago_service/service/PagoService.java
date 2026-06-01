package com.tienda.pago_service.service;

import org.springframework.stereotype.Service;
import com.tienda.pago_service.entity.Pago;
import com.tienda.pago_service.repository.PagoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    public Pago crearPago(Pago pago) { 
        return pagoRepository.save(pago);
    }

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Pago obtenerPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public Pago actualizar(Long id, Pago pagoNuevo){
        Pago pago = pagoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException ("pago no encontrado"));
            return pagoRepository.save(pago);
    }

    public void eliminar(Long id){
        pagoRepository.deleteById(id);
    }

}

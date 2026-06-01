package com.tienda.categoria_service.service;

import org.springframework.stereotype.Service;
import com.tienda.categoria_service.entity.Categoria;
import com.tienda.categoria_service.repository.CategoriaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    //inyecta el repository para acceder a la BD
    private final CategoriaRepository categoriaRepository;
    //guarda una nueva categoria en la BD
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    //te muestra todas las categorias de la BD
    public List<Categoria> listarTodos() {
        return  categoriaRepository.findAll();
    }
    //busca una categoria por id, lanza error si no existe
    public Categoria buscarPorId(long id) {
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }
    //verifica la existencia de un id
    public Boolean existe(Long id) {
        return categoriaRepository.existsById(id);
    }

}

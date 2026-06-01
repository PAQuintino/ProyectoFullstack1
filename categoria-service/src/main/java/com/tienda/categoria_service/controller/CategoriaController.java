package com.tienda.categoria_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tienda.categoria_service.entity.Categoria;
import com.tienda.categoria_service.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;

//marca la clase controlador como REST
@RestController
//define la url de la base del controlador
@RequestMapping("/api/categorias")
//genera constructores automaticos 
@RequiredArgsConstructor
public class CategoriaController {

    //inyecta el service 
    private final CategoriaService categoriaService;

    //crea una nueva categoria 
    @PostMapping
    public ResponseEntity<Categoria> guardar(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(201).body(categoriaService.guardarCategoria(categoria));
    }
    //lista todas las categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listasTodos(){
        return ResponseEntity.ok(categoriaService.listarTodos());
    }
    //busca por ID con el get
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    
}

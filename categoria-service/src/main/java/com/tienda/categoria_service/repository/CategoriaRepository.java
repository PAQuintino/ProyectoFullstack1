package com.tienda.categoria_service.repository;

import com.tienda.categoria_service.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

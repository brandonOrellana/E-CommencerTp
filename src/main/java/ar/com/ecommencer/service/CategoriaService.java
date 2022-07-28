package ar.com.ecommencer.service;

import ar.com.ecommencer.errors.CategoriaNotFoundException;
import ar.com.ecommencer.sva.models.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoriaService {
    Categoria guardarCategoria(Categoria categoria);

    List<Categoria> obtenerCategoria();

    Categoria obtenerCategoriaPorId(Long categoriaId) throws CategoriaNotFoundException;

    void borrarCategoriaPorId(Long categoriaId);

    Categoria modificarCategoria(Long categoriaId, Categoria categoria) throws CategoriaNotFoundException;

    Page<Categoria> obtenerCategoria(Pageable pageable);
}

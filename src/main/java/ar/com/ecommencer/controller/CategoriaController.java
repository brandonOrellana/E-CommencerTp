package ar.com.ecommencer.controller;


import ar.com.ecommencer.errors.CategoriaNotFoundException;
import ar.com.ecommencer.service.CategoriaService;
import ar.com.ecommencer.sva.models.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categorias")
    public Categoria guardarCategoria(@RequestBody Categoria categoria){
        return categoriaService.guardarCategoria(categoria);
    }

    @GetMapping("/categorias")
    public List<Categoria> obtenerCategoria(){
        return categoriaService.obtenerCategoria();
    }

    @GetMapping("/categorias/page")
    public Page<Categoria> obtenerCategoria( Pageable pageable){
        return categoriaService.obtenerCategoria(pageable);
    }

    @GetMapping("/categorias/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable("id") Long categoriaId) throws CategoriaNotFoundException {
        return categoriaService.obtenerCategoriaPorId(categoriaId);
    }

    @DeleteMapping("/categorias/{id}")
    public String borrarCategoriaPorId(@PathVariable("id") Long categoriaId){
        categoriaService.borrarCategoriaPorId(categoriaId);
        return "Se borro la categoria";
    }

    @PutMapping("/categorias/{id}")
    public Categoria modificarCategoria(@PathVariable("id") Long categoriaId,
                                      @RequestBody Categoria categoria) throws CategoriaNotFoundException {
        return categoriaService.modificarCategoria(categoriaId,categoria);
    }
}

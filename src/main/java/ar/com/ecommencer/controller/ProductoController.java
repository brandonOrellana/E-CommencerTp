package ar.com.ecommencer.controller;


import ar.com.ecommencer.dtos.ProductoDTO;
import ar.com.ecommencer.errors.ProductoNotFoundException;
import ar.com.ecommencer.sva.models.entities.Producto;
import ar.com.ecommencer.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @CrossOrigin
    @PostMapping("/productos")
    public ProductoDTO guardarProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }

    @CrossOrigin
    @GetMapping("/productos")
    public List<ProductoDTO> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @CrossOrigin
    @GetMapping("/productos/page")
    public Page<ProductoDTO> obtenerProductos(Pageable pageable){
        return productoService.obtenerProductos(pageable);
    }

    @CrossOrigin
    @GetMapping("/productos/search/page")///productos/search/page?nombre={variable a filtrar}
    public Page<ProductoDTO> obtenerProductosFiltro(@RequestParam String nombre,Pageable pageable){
        return productoService.obtenerProductosFiltro(nombre,pageable);
    }

    @CrossOrigin
    @GetMapping("/productos/{id}")
    public ProductoDTO obtenerProductoPorId(@PathVariable("id") Long productoId) throws ProductoNotFoundException {
        return productoService.obtenerProductoDTOPorId(productoId);
    }

    @DeleteMapping("/productos/{id}")
    public String borrarProductoPorId(@PathVariable("id") Long productoId){
        productoService.borrarProductoPorId(productoId);
        return "Se borro el producto";
    }

    @PutMapping("/productos/{id}")
    public ProductoDTO modificarProductoDTO(@PathVariable("id") Long productoId,
                                      @RequestBody Producto producto){
        return productoService.modificarProductoDTO(productoId,producto);
    }

}

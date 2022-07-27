package ar.com.ecommencer.controller;


import ar.com.ecommencer.sva.models.entities.Producto;
import ar.com.ecommencer.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto obtenerProductoPorId(@PathVariable("id") Long productoId){
        return productoService.obtenerProductoPorId(productoId);
    }

    @DeleteMapping("/productos/{id}")
    public String borrarProductoPorId(@PathVariable("id") Long productoId){
        productoService.borrarProductoPorId(productoId);
        return "Se borro el producto";
    }

    @PutMapping("/productos/{id}")
    public Producto modificarProducto(@PathVariable("id") Long productoId,
                                      @RequestBody Producto producto){
        return productoService.modificarProducto(productoId,producto);
    }

}

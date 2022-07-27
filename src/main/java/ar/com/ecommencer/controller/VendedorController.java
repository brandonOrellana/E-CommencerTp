package ar.com.ecommencer.controller;

import ar.com.ecommencer.service.VendedorService;
import ar.com.ecommencer.sva.models.entities.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping("/vendedores")
    public Vendedor guardarVendedor(@RequestBody Vendedor vendedor){
        return vendedorService.guardarVendedor(vendedor);
    }

    @GetMapping("/vendedores")
    public List<Vendedor> obtenerVendedores(){
        return vendedorService.obtenerVendedores();
    }

    @GetMapping("/vendedores/{id}")
    public Vendedor obtenerVendedorPorId(@PathVariable("id") Long vendedorId){
        return vendedorService.obtenerVendedorPorId(vendedorId);
    }

    @DeleteMapping("/vendedores/{id}")
    public String borrarVendedor(@PathVariable("id") Long vendedorId){
        vendedorService.borrarVendedor(vendedorId);
        return "Se borro al vendedor";
    }

    @PutMapping("/vendedores/{id}")
    public Vendedor modificarVendedor(@PathVariable("id") Long vendedorId,
                                      @RequestBody Vendedor vendedor){
        return vendedorService.modificarVendedor(vendedorId,vendedor);
    }

}
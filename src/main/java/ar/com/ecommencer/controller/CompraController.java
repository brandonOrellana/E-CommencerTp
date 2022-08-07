package ar.com.ecommencer.controller;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.service.CompraService;
import ar.com.ecommencer.sva.models.entities.Categoria;
import ar.com.ecommencer.sva.models.entities.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompraController {
    @Autowired
    private CompraService compraService;

    /*@PostMapping("/compra")
    public Compra guardarCompra(@RequestBody CompraDTO compra){
        return compraService.guardarCompra(compra);
    }*/

    @PostMapping("/compra")
    public CompraDTO guardarCompra(@RequestBody CompraDTO compra){
        return compraService.guardarCompra(compra);
    }
}

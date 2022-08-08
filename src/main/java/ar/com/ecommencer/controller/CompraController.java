package ar.com.ecommencer.controller;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.dtos.ProductoDTO;
import ar.com.ecommencer.service.CompraService;
import ar.com.ecommencer.sva.models.entities.Categoria;
import ar.com.ecommencer.sva.models.entities.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @GetMapping("/compra/search/page")///productos/search/page?idCliente={variable a filtrar}
    public Page<CompraDTO> obtenerComprasCliente(@RequestParam Long idCliente, Pageable pageable){
        return compraService.obtenerComprasCliente(idCliente,pageable);
    }
}

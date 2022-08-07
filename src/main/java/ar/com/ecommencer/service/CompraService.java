package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.sva.models.entities.Compra;

public interface CompraService {
    //Compra guardarCompra(CompraDTO compra);

    CompraDTO guardarCompra(CompraDTO compra);
}

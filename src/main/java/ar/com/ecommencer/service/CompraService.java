package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.dtos.ProductoDTO;
import ar.com.ecommencer.sva.models.entities.Compra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompraService {
    //Compra guardarCompra(CompraDTO compra);

    CompraDTO guardarCompra(CompraDTO compra);

    Page<CompraDTO> obtenerComprasCliente(Long idCliente, Pageable pageable);
}

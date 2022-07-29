package ar.com.ecommencer.service;

import ar.com.ecommencer.errors.VendedorNotFoundException;
import ar.com.ecommencer.sva.models.entities.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VendedorService {
    Vendedor guardarVendedor(Vendedor vendedor);

    List<Vendedor> obtenerVendedores();

    Vendedor obtenerVendedorPorId(Long vendedorId) throws VendedorNotFoundException;

    void borrarVendedor(Long vendedorId);

    Vendedor modificarVendedor(Long vendedorId, Vendedor vendedor);

    Page<Vendedor> obtenerVendedores(Pageable pageable);
}

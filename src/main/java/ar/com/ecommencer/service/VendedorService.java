package ar.com.ecommencer.service;

import ar.com.ecommencer.sva.models.entities.Vendedor;

import java.util.List;

public interface VendedorService {
    Vendedor guardarVendedor(Vendedor vendedor);

    List<Vendedor> obtenerVendedores();

    Vendedor obtenerVendedorPorId(Long vendedorId);

    void borrarVendedor(Long vendedorId);

    Vendedor modificarVendedor(Long vendedorId, Vendedor vendedor);
}

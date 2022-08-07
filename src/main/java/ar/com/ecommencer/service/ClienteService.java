package ar.com.ecommencer.service;

import ar.com.ecommencer.errors.ClienteNotFoundException;
import ar.com.ecommencer.sva.models.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
    Cliente guardarCliente(Cliente cliente);

    Page<Cliente> obtenerClientes(Pageable pageable);

    Cliente obtenerClientesPorId(Long clienteId) throws ClienteNotFoundException;

    void borrarCliente(Long clienteId);

    Cliente modificarVendedor(Long clienteId, Cliente cliente) throws ClienteNotFoundException;
}

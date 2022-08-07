package ar.com.ecommencer.controller;

import ar.com.ecommencer.errors.ClienteNotFoundException;
import ar.com.ecommencer.errors.VendedorNotFoundException;
import ar.com.ecommencer.service.ClienteService;
import ar.com.ecommencer.sva.models.entities.Cliente;
import ar.com.ecommencer.sva.models.entities.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    public Cliente guardarClientes(@RequestBody Cliente cliente){
        return clienteService.guardarCliente(cliente);
    }

    /*@GetMapping("/clientes")
    public List<Cliente> obtenerClientes(){
        return clienteService.obtenerClientes();
    }*/

    @GetMapping("/clientes/page")
    public Page<Cliente> obtenerClientes(Pageable pageable){
        return clienteService.obtenerClientes(pageable);
    }

    @GetMapping("/clientes/{id}")
    public Cliente obtenerClientesPorId(@PathVariable("id") Long clienteId) throws ClienteNotFoundException {
        return clienteService.obtenerClientesPorId(clienteId);
    }

    @DeleteMapping("/clientes/{id}")
    public String borrarClientes(@PathVariable("id") Long clienteId){
        clienteService.borrarCliente(clienteId);
        return "Se borro al clientes";
    }

    @PutMapping("/clientes/{id}")
    public Cliente modificarClientes(@PathVariable("id") Long clienteId,
                                      @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return clienteService.modificarVendedor(clienteId,cliente);
    }
}

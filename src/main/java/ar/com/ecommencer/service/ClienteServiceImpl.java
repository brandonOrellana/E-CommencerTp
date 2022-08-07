package ar.com.ecommencer.service;

import ar.com.ecommencer.errors.CategoriaNotFoundException;
import ar.com.ecommencer.errors.ClienteNotFoundException;
import ar.com.ecommencer.sva.models.entities.Categoria;
import ar.com.ecommencer.sva.models.entities.Cliente;
import ar.com.ecommencer.sva.models.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Page<Cliente> obtenerClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente obtenerClientesPorId(Long clienteId) throws ClienteNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if(!cliente.isPresent()){
            throw new ClienteNotFoundException("Categoria no encontrada");
        }
        return cliente.get();
    }

    @Override
    public void borrarCliente(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    @Override
    public Cliente modificarVendedor(Long clienteId, Cliente cliente) throws ClienteNotFoundException {

        Optional<Cliente> clienteOptionalDB = clienteRepository.findById(clienteId);
        if(!clienteOptionalDB.isPresent()){
            throw new ClienteNotFoundException("Categoria no encontrada");
        }
        Cliente clienteDB = clienteOptionalDB.get();

        if(Objects.nonNull(cliente.getNombre()) &&
                !"".equalsIgnoreCase(cliente.getNombre())){
            cliente.setNombre(cliente.getNombre());
        }

        return clienteRepository.save(clienteDB);
    }
}

package ar.com.ecommencer.service;

import ar.com.ecommencer.sva.models.entities.Vendedor;
import ar.com.ecommencer.sva.models.repositories.VendedorRepository;
import org.aspectj.weaver.VersionedDataInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService{

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public Vendedor guardarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    @Override
    public List<Vendedor> obtenerVendedores() {
        return vendedorRepository.findAll();
    }

    @Override
    public Vendedor obtenerVendedorPorId(Long vendedorId) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(vendedorId);
        return vendedor.get();
    }

    @Override
    public void borrarVendedor(Long vendedorId) {
        vendedorRepository.deleteById(vendedorId);
    }

    @Override
    public Vendedor modificarVendedor(Long vendedorId, Vendedor vendedor) {
        Vendedor vendedorDB = vendedorRepository.findById(vendedorId).get();

        vendedorDB.setNombre(vendedor.getNombre());
        vendedorDB.setApellido(vendedor.getApellido());
        vendedorDB.setTelefono(vendedor.getTelefono());
        vendedorDB.setFechaNacimiento(vendedor.getFechaNacimiento());

        return vendedorRepository.save(vendedorDB);

    }
}

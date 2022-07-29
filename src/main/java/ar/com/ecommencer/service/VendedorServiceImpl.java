package ar.com.ecommencer.service;

import ar.com.ecommencer.errors.VendedorNotFoundException;
import ar.com.ecommencer.sva.models.entities.Vendedor;
import ar.com.ecommencer.sva.models.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public Page<Vendedor> obtenerVendedores(Pageable pageable) {
        return vendedorRepository.findAll(pageable);
    }
    @Override
    public Vendedor obtenerVendedorPorId(Long vendedorId) throws VendedorNotFoundException {
        Optional<Vendedor> vendedor = vendedorRepository.findById(vendedorId);

        if(!vendedor.isPresent()){
            throw new VendedorNotFoundException("Vendedor no encontrada");
        }

        return vendedor.get();
    }

    @Override
    public void borrarVendedor(Long vendedorId) {
        vendedorRepository.deleteById(vendedorId);
    }

    @Override
    public Vendedor modificarVendedor(Long vendedorId, Vendedor vendedor) {
        Vendedor vendedorDB = vendedorRepository.findById(vendedorId).get();

        if(Objects.nonNull(vendedor.getNombre()) &&
                !"".equalsIgnoreCase(vendedor.getNombre())){
            vendedorDB.setNombre(vendedor.getNombre());
        }
        if(Objects.nonNull(vendedor.getApellido()) &&
                !"".equalsIgnoreCase(vendedor.getApellido())){
            vendedorDB.setApellido(vendedor.getApellido());
        }
        if(Objects.nonNull(vendedor.getTelefono()) &&
                !"".equalsIgnoreCase(vendedor.getTelefono())){
            vendedorDB.setTelefono(vendedor.getTelefono());
        }
        if(Objects.nonNull(vendedor.getFechaNacimiento())){
            vendedorDB.setFechaNacimiento(vendedor.getFechaNacimiento());
        }

        return vendedorRepository.save(vendedorDB);

    }
}

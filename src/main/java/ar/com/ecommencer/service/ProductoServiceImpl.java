package ar.com.ecommencer.service;

import ar.com.ecommencer.errors.CategoriaNotFoundException;
import ar.com.ecommencer.errors.ProductoNotFoundException;
import ar.com.ecommencer.sva.models.entities.Producto;
import ar.com.ecommencer.sva.models.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Page<Producto> obtenerProductos(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }
    @Override
    public Producto obtenerProductoPorId(Long productoId) throws ProductoNotFoundException {
        Optional<Producto> producto = productoRepository.findById(productoId);

        if(!producto.isPresent()){
            throw new ProductoNotFoundException("Producto no encontrada");
        }
        return producto.get();
    }

    @Override
    public void borrarProductoPorId(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    @Override
    public Producto modificarProducto(Long productoId, Producto producto) {
        Producto productoDB = productoRepository.findById(productoId).get();

        if(Objects.nonNull(producto.getNombre()) &&
                !"".equalsIgnoreCase(producto.getNombre())){
            productoDB.setNombre(producto.getNombre());
        }
        if(Objects.nonNull(producto.getDescripcion()) &&
                !"".equalsIgnoreCase(producto.getDescripcion())){
            productoDB.setDescripcion(producto.getDescripcion());
        }
        if(Objects.nonNull(producto.getStock()) &&
                producto.getStock()>=0){
            productoDB.setStock(producto.getStock());
        }
        if(Objects.nonNull(producto.getPrecio()) &&
                producto.getPrecio()>=0){
            productoDB.setPrecio(producto.getPrecio());
        }

        return productoRepository.save(productoDB);
    }
}

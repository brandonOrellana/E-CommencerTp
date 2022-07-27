package ar.com.ecommencer.service;

import ar.com.ecommencer.sva.models.entities.Producto;
import ar.com.ecommencer.sva.models.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Producto obtenerProductoPorId(Long productoId) {
        Optional<Producto> producto = productoRepository.findById(productoId);
        return producto.get();
    }

    @Override
    public void borrarProductoPorId(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    @Override
    public Producto modificarProducto(Long productoId, Producto producto) {
        Producto productoDB = productoRepository.findById(productoId).get();

        productoDB.setNombre(producto.getNombre());
        productoDB.setDescripcion(producto.getDescripcion());
        productoDB.setStock(producto.getStock());
        productoDB.setPrecio(producto.getPrecio());

        return productoRepository.save(productoDB);
    }
}

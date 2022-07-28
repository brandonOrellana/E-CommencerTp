package ar.com.ecommencer.service;

import ar.com.ecommencer.sva.models.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    public Producto guardarProducto(Producto producto);

    public List<Producto> obtenerProductos();

    public Producto obtenerProductoPorId(Long productoId);

    public void borrarProductoPorId(Long productoId);

    public Producto modificarProducto(Long productoId, Producto producto);

    Page<Producto> obtenerProductos(Pageable pageable);
}

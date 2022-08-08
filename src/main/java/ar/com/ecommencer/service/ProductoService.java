package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.ProductoDTO;
import ar.com.ecommencer.errors.ProductoNotFoundException;
import ar.com.ecommencer.sva.models.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    public ProductoDTO guardarProducto(Producto producto);

    public List<ProductoDTO> obtenerProductos();

    public Producto obtenerProductoPorId(Long productoId) throws ProductoNotFoundException;

    public ProductoDTO obtenerProductoDTOPorId(Long productoId) throws ProductoNotFoundException;

    public void borrarProductoPorId(Long productoId);

    public Producto modificarProducto(Long productoId, Producto producto);

    Page<ProductoDTO> obtenerProductos(Pageable pageable);

    ProductoDTO modificarProductoDTO(Long productoId, Producto producto);

    Page<ProductoDTO> obtenerProductosFiltro(String nombre,Pageable pageable);
}

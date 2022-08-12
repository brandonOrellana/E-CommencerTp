package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.dtos.ProductoDTO;
import ar.com.ecommencer.errors.CategoriaNotFoundException;
import ar.com.ecommencer.errors.ProductoNotFoundException;
import ar.com.ecommencer.errors.VendedorNotFoundException;
import ar.com.ecommencer.sva.models.entities.*;
import ar.com.ecommencer.sva.models.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private DolarService dolarService;

    @Override
    public ProductoDTO guardarProducto(Producto producto) {
        Categoria categoriaDB;
        try {
            categoriaDB = categoriaService.obtenerCategoriaPorId(producto.getCategoria().getId());
        } catch (CategoriaNotFoundException e) {
            throw new RuntimeException(e);
        }

        Vendedor vendedorDB;

        try {
            vendedorDB = vendedorService.obtenerVendedorPorId(producto.getVendedor().getId());
        } catch (VendedorNotFoundException e) {
            throw new RuntimeException(e);
        }

        producto.setCategoria(categoriaDB);
        producto.setVendedor(vendedorDB);

        Producto producto1 = productoRepository.save(producto);
        ProductoDTO productoDTO = this.toProductoDTO(producto1);
        return productoDTO;
    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(m -> toProductoDTO(m)).collect(Collectors.toList());
    }

    @Override
    public Page<ProductoDTO> obtenerProductos(Pageable pageable) {
        return productoRepository.findAll(pageable).map(m->this.toProductoDTO(m));
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
    public ProductoDTO obtenerProductoDTOPorId(Long productoId) throws ProductoNotFoundException {
        Optional<Producto> producto = productoRepository.findById(productoId);

        if(!producto.isPresent()){
            throw new ProductoNotFoundException("Producto no encontrada");
        }
        return this.toProductoDTO(producto.get());
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

    @Override
    public ProductoDTO modificarProductoDTO(Long productoId, Producto producto) {
        Producto productoDB = productoRepository.findById(productoId).get();

        Categoria categoriaNueva;
        try {
            categoriaNueva = categoriaService.obtenerCategoriaPorId(producto.getCategoria().getId());
        } catch (CategoriaNotFoundException e) {
            throw new RuntimeException(e);
        }

        productoDB.setCategoria(categoriaNueva);


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
        Producto productoGuardado = productoRepository.save(productoDB);
        return this.toProductoDTO(productoGuardado);
    }

    @Override
    public Page<ProductoDTO> obtenerProductosFiltro(String nombre,Pageable pageable) {
        return productoRepository.findProductoByNombreContainsIgnoreCase(nombre,pageable).map(m->this.toProductoDTO(m));
    }

    public ProductoDTO toProductoDTO(Producto producto){
        ProductoDTO productoDTO = ProductoDTO.builder()
                .id(producto.getId())
                .vendedor(producto.getVendedor().getNombre())
                .categoria(producto.getCategoria().getNombre())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .stock(producto.getStock())
                .precio(producto.getPrecio())
                .precioDolar(this.redondearDecimales(producto.getPrecio()/ dolarService.getVenta()))
                .imagen(producto.getImagen())
                .build();
        return productoDTO;
    }

    public Double redondearDecimales(Double numero){
        return Math.round(numero * 100) / 100d;
    }
}

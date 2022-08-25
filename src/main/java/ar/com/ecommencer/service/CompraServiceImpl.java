package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.dtos.ItemCompraDTO;
import ar.com.ecommencer.errors.ClienteNotFoundException;
import ar.com.ecommencer.errors.ProductoNotFoundException;
import ar.com.ecommencer.sva.models.entities.Cliente;
import ar.com.ecommencer.sva.models.entities.Compra;
import ar.com.ecommencer.sva.models.entities.ItemCompra;
import ar.com.ecommencer.sva.models.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private DolarServiceImpl dolarServiceImpl;
    /*
    @Override
    public Compra guardarCompra(CompraDTO compraDTO) {
        return compraRepository.save(this.toCompra(compraDTO));
    }*/

    @Override
    public CompraDTO guardarCompra(CompraDTO compraDTO) {
        compraRepository.save(this.toCompra(compraDTO));
        Compra compra = this.toCompra(compraDTO);
        Double totalDolares = this.convertirADolar(compra.getTotalAPagar());
        CompraDTO nuevaDTO = CompraDTO.builder()
                .idCliente(compraDTO.getIdCliente())
                .medioDePago(compraDTO.getMedioDePago())
                .itemsDTO(compraDTO.getItemsDTO())
                .moneda(compraDTO.getMoneda())
                .totalAPagar(compra.getTotalAPagar())
                .precioEnDolares(redondearDecimales(totalDolares))
                .build();

        return nuevaDTO;

    }

    @Override
    public Page<CompraDTO> obtenerComprasCliente(Long idCliente, Pageable pageable) {
        Cliente cliente;
        try {
            cliente = clienteService.obtenerClientesPorId(idCliente);
        } catch (ClienteNotFoundException e) {
            throw new RuntimeException(e);
        }
        return compraRepository.findAllByCliente(cliente, pageable).map(m->this.compraDTO(m));
    }


    public Compra toCompra(CompraDTO compraDTO){
        Cliente clienteDB = null;
        try {
            clienteDB = clienteService.obtenerClientesPorId(compraDTO.getIdCliente());
        } catch (ClienteNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<ItemCompra> items = compraDTO.getItemsDTO().stream().map(m -> this.toItemCompra(m)).collect(Collectors.toList());


        Double total = items.stream().mapToDouble(ItemCompra::getPrecio).sum();

        Compra compra1 = Compra.builder()
                .cliente(clienteDB)
                .medioDePago(compraDTO.getMedioDePago())
                .productos(items)
                .totalAPagar(total)
                .fechaCompra(LocalDate.now())
                .build();
        return compra1;
    }

    public CompraDTO compraDTO(Compra compra){
        Double totalDolares = this.convertirADolar(compra.getTotalAPagar());
        CompraDTO nuevaDTO = CompraDTO.builder()
                .idCliente(compra.getCliente().getId())
                .medioDePago(compra.getMedioDePago())
                .itemsDTO(compra.getProductos().stream().map(m->this.toItemCompraDTO(m)).collect(Collectors.toList()))
                .moneda(compra.getMedioDePago())
                .totalAPagar(compra.getTotalAPagar())
                .precioEnDolares(totalDolares)
                .build();
        return  nuevaDTO;
    }
    public ItemCompra toItemCompra(ItemCompraDTO itemCompraDTO){
        ItemCompra itemCompra = new ItemCompra();
        try {
            itemCompra.setProducto(productoService.obtenerProductoPorId(itemCompraDTO.getIdProducto()));
        } catch (ProductoNotFoundException e) {
            throw new RuntimeException(e);
        }
        itemCompra.setCantidad(itemCompraDTO.getCantidad());
        Double precio = itemCompra.getProducto().getPrecio();
        itemCompra.setPrecio(precio*itemCompraDTO.getCantidad());

        return itemCompra;
    }

    public ItemCompraDTO toItemCompraDTO(ItemCompra itemCompra){
        ItemCompraDTO itemCompraDTO1 = ItemCompraDTO.builder()
                .idProducto(itemCompra.getId())
                .cantidad(itemCompra.getCantidad())
                .build();
        return itemCompraDTO1;
    }

    public Double convertirADolar(Double pesos){
        //dolarService.init();
        return pesos/ dolarServiceImpl.getVenta();
    }

    public Double redondearDecimales(Double numero){
        return Math.round(numero * 100) / 100d;
    }

}

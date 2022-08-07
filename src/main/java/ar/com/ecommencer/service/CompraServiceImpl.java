package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.CompraDTO;
import ar.com.ecommencer.dtos.DolarDTP;
import ar.com.ecommencer.dtos.ItemCompraDTO;
import ar.com.ecommencer.errors.ClienteNotFoundException;
import ar.com.ecommencer.errors.ProductoNotFoundException;
import ar.com.ecommencer.sva.models.entities.Categoria;
import ar.com.ecommencer.sva.models.entities.Cliente;
import ar.com.ecommencer.sva.models.entities.Compra;
import ar.com.ecommencer.sva.models.entities.ItemCompra;
import ar.com.ecommencer.sva.models.repositories.ClienteRepository;
import ar.com.ecommencer.sva.models.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DolarService dolarService;
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
                .precioEnDolares(totalDolares)
                .build();

        return nuevaDTO;

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

    public Double convertirADolar(Double pesos){
        //dolarService.init();
        return pesos/dolarService.getVenta();
    }

}

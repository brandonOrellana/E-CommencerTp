package ar.com.ecommencer.dtos;

import ar.com.ecommencer.errors.ClienteNotFoundException;
import ar.com.ecommencer.service.ClienteService;
import ar.com.ecommencer.sva.models.entities.Compra;
import ar.com.ecommencer.sva.models.entities.Cliente;
import ar.com.ecommencer.sva.models.entities.ItemCompra;
import ar.com.ecommencer.sva.models.entities.Producto;
import ar.com.ecommencer.sva.models.repositories.ClienteRepository;
import ar.com.ecommencer.sva.models.repositories.ProductoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraDTO {
    private Long idCliente;
    private List<ItemCompraDTO> itemsDTO;
    private String medioDePago;
    private String moneda;
    private Double totalAPagar;
    private Double precioEnDolares;
}

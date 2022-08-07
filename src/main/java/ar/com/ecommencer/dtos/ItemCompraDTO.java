package ar.com.ecommencer.dtos;

import ar.com.ecommencer.errors.ProductoNotFoundException;
import ar.com.ecommencer.service.ProductoService;
import ar.com.ecommencer.sva.models.entities.ItemCompra;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCompraDTO {
    private Long idProducto;
    private Integer cantidad;
}

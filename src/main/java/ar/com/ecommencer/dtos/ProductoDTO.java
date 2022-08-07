package ar.com.ecommencer.dtos;

import ar.com.ecommencer.sva.models.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private Long id;
    private String vendedor;
    private String categoria;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private Double precio;
}

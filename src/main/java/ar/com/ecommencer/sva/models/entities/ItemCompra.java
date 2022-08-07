package ar.com.ecommencer.sva.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "itemcompra")
public class ItemCompra extends Persistente{
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;
    private Integer cantidad;
    private Double precio;
}

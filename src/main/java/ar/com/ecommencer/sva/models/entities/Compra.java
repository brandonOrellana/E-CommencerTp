package ar.com.ecommencer.sva.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "compra")
public class Compra extends Persistente{
    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "id_compra",
            referencedColumnName = "id"
    )
    private List<ItemCompra> productos;

    @Column(name = "fecha_compra", columnDefinition = "DATE")
    private LocalDate fechaCompra;
    private String medioDePago;
    private Double totalAPagar;
}

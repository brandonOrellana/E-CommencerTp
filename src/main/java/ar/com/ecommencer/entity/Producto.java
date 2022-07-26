package ar.com.ecommencer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long idProducto;

    @Column(name = "nombre",columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Column(name = "descripcion",columnDefinition = "VARCHAR(255)")
    private String descripcion;

    @Column(name = "stock",columnDefinition = "INTEGER(4)")
    private Integer stock;

    @Column(name = "precio",columnDefinition = "DOUBLE")
    private Double precion;

}

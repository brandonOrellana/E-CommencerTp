package ar.com.ecommencer.sva.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "producto")
public class Producto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id")
    private Vendedor vendedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    @Column(name = "nombre",columnDefinition = "VARCHAR(255)")
    private String nombre;

    @Column(name = "descripcion",columnDefinition = "VARCHAR(255)")
    private String descripcion;

    @Column(name = "stock",columnDefinition = "INTEGER(4)")
    private Integer stock;

    @Column(name = "precio",columnDefinition = "DOUBLE")
    private Double precio;

    @Column(name = "imagen",columnDefinition = "VARCHAR(255)")
    private String imagen;
}

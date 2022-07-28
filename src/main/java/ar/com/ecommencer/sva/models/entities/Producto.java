package ar.com.ecommencer.sva.models.entities;

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
public class Producto extends Persistente{

    @Column(name = "nombre",columnDefinition = "VARCHAR(255)")
    private String nombre;

    @Column(name = "descripcion",columnDefinition = "VARCHAR(255)")
    private String descripcion;

    @Column(name = "stock",columnDefinition = "INTEGER(4)")
    private Integer stock;

    @Column(name = "precio",columnDefinition = "DOUBLE")
    private Double precio;

}

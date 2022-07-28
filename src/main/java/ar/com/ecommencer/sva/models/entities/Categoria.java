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
public class Categoria extends Persistente{

    @Column(name = "nombre", columnDefinition = "VARCHAR(255)")
    private String nombre;
}

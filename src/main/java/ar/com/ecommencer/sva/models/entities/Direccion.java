package ar.com.ecommencer.sva.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "calle",
                column = @Column(name = "direccion_calle")
        ),
        @AttributeOverride(
                name = "ciudad",
                column = @Column(name = "direccion_ciudad")
        ),
        @AttributeOverride(
                name = "codigoPostal",
                column = @Column(name = "direccion_codigopostal")
        ),
        @AttributeOverride(
                name = "pais",
                column = @Column(name = "direccion_pais")
        )
})
public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String pais;
}

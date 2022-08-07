package ar.com.ecommencer.sva.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "usuario",
                column = @Column(name = "cuenta_usuario")
        ),
        @AttributeOverride(
                name = "contrasenia",
                column = @Column(name = "cuenta_contrasenia")
        )
})
public class Cuenta{
    private String usuario;
    private String contrasenia;

}

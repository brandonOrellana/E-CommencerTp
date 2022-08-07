package ar.com.ecommencer.sva.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente extends Persona{

}

package ar.com.ecommencer.sva.models.entities;

import javax.persistence.*;

@MappedSuperclass
public class Persistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId(){
        return id;
    }
}

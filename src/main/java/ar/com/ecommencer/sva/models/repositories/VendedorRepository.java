package ar.com.ecommencer.sva.models.repositories;

import ar.com.ecommencer.sva.models.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long> {

}

package ar.com.ecommencer.sva.models.repositories;

import ar.com.ecommencer.sva.models.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}

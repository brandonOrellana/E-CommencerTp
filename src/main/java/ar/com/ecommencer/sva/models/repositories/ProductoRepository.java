package ar.com.ecommencer.sva.models.repositories;

import ar.com.ecommencer.sva.models.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    Page<Producto> findProductoByNombreContainsIgnoreCase(String nombre, Pageable pageable);
}

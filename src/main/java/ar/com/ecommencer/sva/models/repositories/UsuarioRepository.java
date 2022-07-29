package ar.com.ecommencer.sva.models.repositories;

import ar.com.ecommencer.sva.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController(path = "usuarios")
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);
}

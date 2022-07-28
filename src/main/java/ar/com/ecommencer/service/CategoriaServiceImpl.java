package ar.com.ecommencer.service;

import ar.com.ecommencer.errors.CategoriaNotFoundException;
import ar.com.ecommencer.sva.models.entities.Categoria;
import ar.com.ecommencer.sva.models.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> obtenerCategoria() {
        return categoriaRepository.findAll();
    }
    @Override
    public Page<Categoria> obtenerCategoria(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }
    @Override
    public Categoria obtenerCategoriaPorId(Long categoriaId) throws CategoriaNotFoundException {
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
        if(!categoria.isPresent()){
            throw new CategoriaNotFoundException("Categoria no encontrada");
        }
        return categoria.get();
    }

    @Override
    public void borrarCategoriaPorId(Long categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

    @Override
    public Categoria modificarCategoria(Long categoriaId, Categoria categoria) throws CategoriaNotFoundException {
        Optional<Categoria> categoriaOptionalDB = categoriaRepository.findById(categoriaId);
        if(!categoriaOptionalDB.isPresent()){
            throw new CategoriaNotFoundException("Categoria no encontrada");
        }
        Categoria categoriaDB = categoriaOptionalDB.get();

        categoriaDB.setNombre(categoria.getNombre());

        return categoriaRepository.save(categoriaDB);
    }




}

package ar.com.ecommencer;

import ar.com.ecommencer.service.ProductoService;
import ar.com.ecommencer.sva.models.entities.Categoria;
import ar.com.ecommencer.sva.models.entities.Producto;
import ar.com.ecommencer.sva.models.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class EcommencerApplication{

	public static void main(String[] args) {
		SpringApplication.run(EcommencerApplication.class, args);
	}

	@Autowired
	private ProductoRepository productoRepository;


}

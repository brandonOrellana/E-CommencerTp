package ar.com.ecommencer;


import ar.com.ecommencer.service.DolarServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EcommencerApplication implements CommandLineRunner{

	@Autowired
	private DolarServiceImpl dolarServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(EcommencerApplication.class, args);
	}


	@Override
	public void run(String... args){
		dolarServiceImpl.init();
	}
}

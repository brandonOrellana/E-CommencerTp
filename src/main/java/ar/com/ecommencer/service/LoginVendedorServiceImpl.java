package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.LoginDTO;
import ar.com.ecommencer.sva.models.entities.Cliente;
import ar.com.ecommencer.sva.models.entities.Vendedor;
import ar.com.ecommencer.sva.models.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginVendedorServiceImpl {

    @Autowired
    private VendedorRepository vendedorRepository;

    public LoginDTO validarLogin(LoginDTO login) {
        Vendedor vendedor = vendedorRepository.findVendedorByGmail(login.getEmail());

        if(Objects.isNull(vendedor)){
            return LoginDTO.builder()
                    .email(login.getEmail())
                    .contrasenia(login.getContrasenia())
                    .estado(false)
                    .nombre("")
                    .mensage("cliente no econtrado")
                    .build();
        }


        if(vendedor.getCuenta().getContrasenia().equals(login.getContrasenia())){
            return LoginDTO.builder()
                    .email(login.getEmail())
                    .contrasenia(login.getContrasenia())
                    .estado(true)
                    .nombre(vendedor.getNombre())
                    .mensage("perfecto")
                    .id(vendedor.getId())
                    .build();
        }
        return LoginDTO.builder()
                .email(login.getEmail())
                .contrasenia(login.getContrasenia())
                .estado(false)
                .nombre("")
                .mensage("error contrasenia")
                .build();
    }
}

package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.LoginDTO;
import ar.com.ecommencer.sva.models.entities.Cliente;
import ar.com.ecommencer.sva.models.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private ClienteRepository clienteRepository;

    public LoginDTO validarLogin(LoginDTO login) {
        Cliente cliente = clienteRepository.findClienteByGmail(login.getEmail());

        if(Objects.isNull(cliente)){
            return LoginDTO.builder()
                    .email(login.getEmail())
                    .contrasenia(login.getContrasenia())
                    .estado(false)
                    .nombre("")
                    .mensage("cliente no econtrado")
                    .build();
        }


        if(cliente.getCuenta().getContrasenia().equals(login.getContrasenia())){
            return LoginDTO.builder()
                    .email(login.getEmail())
                    .contrasenia(login.getContrasenia())
                    .estado(true)
                    .nombre(cliente.getNombre())
                    .mensage("perfecto")
                    .id(cliente.getId())
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

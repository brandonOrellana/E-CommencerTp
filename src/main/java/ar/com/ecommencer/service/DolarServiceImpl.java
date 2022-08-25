package ar.com.ecommencer.service;

import ar.com.ecommencer.dtos.DolarDTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DolarServiceImpl implements DolarService{
    @Autowired
    DolarDTP dolarDTP;

    public DolarServiceImpl() {
        this.init();
    }
    public void init() {
        String url = "https://api-dolar-argentina.herokuapp.com/api/dolarblue";
        RestTemplate restTemplate = new RestTemplate();
        this.dolarDTP = restTemplate.getForObject(url,DolarDTP.class);
    }

    public Double getVenta(){
        return dolarDTP.getVenta();
    }

    public String getFecha(){
        return dolarDTP.getFecha();
    }
}

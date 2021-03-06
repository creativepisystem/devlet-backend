package br.com.creative.devlet.service;

import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.AuthenticateCepModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class IntegrationServiceImpl implements IntegrationService{

    @Override
    public AuthenticateCepModel getAdressByZipCode(String cep) throws BussinessException {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject("https://viacep.com.br/ws/" + cep.replaceAll("[^0-9]", "") + "/json/", AuthenticateCepModel.class);
        } catch (Exception e) {
            throw NON_EXISTENT_CEP_EXCEPTION;
        }
    }

}

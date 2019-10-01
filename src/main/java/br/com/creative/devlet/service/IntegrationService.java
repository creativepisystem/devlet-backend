package br.com.creative.devlet.service;

import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.ViaCepModel;

public interface IntegrationService {

    BussinessException NON_EXISTENT_CEP_EXCEPTION = new BussinessException("The Cep doesn't exists");

    ViaCepModel getAdressByZipCode(String cep) throws BussinessException;

}

package br.com.creative.devlet.service;

import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.AuthenticateCepModel;

public interface IntegrationService {
    //Business Exception regarding the nonexistence of a Cep returned by the ViaCep API
    BussinessException NON_EXISTENT_CEP_EXCEPTION = new BussinessException("The Cep doesn't exists");

    /**
     * Validates the existence of a given CEP
     * @param cep : CEP
     * @return : metadata of the given CEP
     * @throws BussinessException : CEP doesn't exists
     */
    AuthenticateCepModel getAdressByZipCode(String cep) throws BussinessException;

}

package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.EnterprisePostModel;
import br.com.creative.devlet.model.GetEnterpriseModel;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {

    BussinessException NON_UNIQUE_CNPJ_EXCEPTION = new BussinessException("There is a matching cnpj in use");
    BussinessException NON_UNIQUE_EMAIL_EXCEPTION = new BussinessException("Ther is a matching email in use");
    BussinessException CNPJ_DOES_NOT_MATCH_ID_EXCEPTION = new BussinessException("The Cnpj doesn't match the enterprise Id");
    BussinessException ENTERPRISE_CREATION_DENIED_EXCEPTION = new BussinessException("The creation of a enterprise is not possible");

    Optional<Enterprise> findById(Long id);

    List<Enterprise> findAll();

    Enterprise create(EnterprisePostModel model) throws BussinessException;

    Enterprise update(EnterprisePostModel model) throws BussinessException;

    void delete(Long id);

    Optional<Enterprise> findByCnpj(String cnpj);

    Optional<Enterprise> findByEmail(String email);

    GetEnterpriseModel convertEntityToGetEnterpriseModel(Enterprise entity);

    void save(Enterprise entity);

}

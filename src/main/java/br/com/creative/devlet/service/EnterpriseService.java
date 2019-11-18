package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.EnterprisePostModel;
import br.com.creative.devlet.model.GetEnterpriseModel;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {
    //Business Exception regarding the existence of a matching cnpj inside the data base
    BussinessException NON_UNIQUE_CNPJ_EXCEPTION = new BussinessException("There is a matching cnpj in use");
    //Business Exception regarding the existence of a matching email inside the data base
    BussinessException NON_UNIQUE_EMAIL_EXCEPTION = new BussinessException("Ther is a matching email in use");
    //Business Exception regarding the defence between the given cnpj and the cnpj within the requested enterprise
    BussinessException CNPJ_DOES_NOT_MATCH_ID_EXCEPTION = new BussinessException("The Cnpj doesn't match the enterprise Id");
    //Business Exception regarding the unaccomplished requirements given for the creation of a enterprise
    BussinessException ENTERPRISE_CREATION_DENIED_EXCEPTION = new BussinessException("The creation of a enterprise is not possible");

    /**
     * selects the enterprise witch matches the Id
     * @param id : enterprise's Id
     * @return : enterprise with a matching Id
     */
    Optional<Enterprise> findById(Long id);

    /**
     * selects all the enterprises inside the database
     * @return : list of enterprises
     */
    List<Enterprise> findAll();

    /**
     * creates a enterprise
     * @param model : model class containing the necessary attributes for the enterprise's creation
     * @return : created enterprise
     * @throws BussinessException : business exception regarding the non-fulfilment of requirements
     */
    Enterprise create(EnterprisePostModel model) throws BussinessException;

    /**
     * updates a enterprise
     * @param model : model class containing the necessary attributes for the enterprise's update
     * @return : updated enterprise
     * @throws BussinessException : business exception regarding the non-fulfilment of requirements
     */
    Enterprise update(EnterprisePostModel model) throws BussinessException;

    /**
     * deletes a enterprise
     * @param id : the deletion target enterprise
     */
    void delete(Long id);

    /**
     * selects a enterprise witch matches the cnpj
     * @param cnpj : enterprise's cnpj
     * @return : enterprise with a matching cnpj
     */
    Optional<Enterprise> findByCnpj(String cnpj);

    /**
     * selects a enterprise witch matches the cnpj
     * @param email : enterprise's email
     * @return : enterprise with a matching email
     */
    Optional<Enterprise> findByEmail(String email);

    /**
     * converts a entity to the model class used by the get statement
     * @param entity : desired enterprise
     * @return : corresponding get model class
     */
    GetEnterpriseModel convertEntityToGetEnterpriseModel(Enterprise entity);

    /**
     * save statement regarding the enterprise
     * @param entity : desired enterprise
     */
    void save(Enterprise entity);

}

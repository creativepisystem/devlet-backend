package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.exception.BussinessException;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    //Business Exception regarding the existence of a matching cpf inside the data base
    BussinessException NON_UNIQUE_CPF_EXCEPTION = new BussinessException("There is a matching Cpf in use");
    //Business Exception regarding the difference between the given cpf and the cpf within the requested person
    BussinessException CPF_DOES_NOT_MATCH_ID_EXCEPTION = new BussinessException("The Cpf doesn't match the person Id");

    /**
     * selects the person witch matches the Id
     * @param id : person's Id
     * @return : person with a matching Id
     */
    Optional<Person> findById(Long id);

    /**
     * selects all persons inside the database
     * @return : list of persons
     */
    List<Person> findAll();

//    Person create (UserAndPersonModel model) throws BussinessException;

//    Person update (UserAndPersonModel model) throws BussinessException;

    /**
     * deletes the persons witch matches the id
     * @param id : the deletion target person
     */
    void delete(Long id);

    /**
     * selects a enterprise witch matches the cpf
     * @param cpf : person's cpf
     * @return : person with a matching cpf
     */
    Optional<Person> findByCpf(String cpf);

    /**
     * save statement regarding the persons
     * @param entity : desired person
     */
    void save(Person entity);
}

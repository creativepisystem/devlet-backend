package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.exception.BussinessException;

import java.util.List;
import java.util.Optional;


public interface PersonService {

    BussinessException NON_UNIQUE_CPF_EXCEPTION = new BussinessException("There is a matching Cpf in use");
    BussinessException CPF_DOES_NOT_MATCH_ID_EXCEPTION = new BussinessException("The Cpf doesn't match the person Id");

    Optional<Person> findById(Long id);

    List<Person> findAll();

//    Person create (UserAndPersonModel model) throws BussinessException;

//    Person update (UserAndPersonModel model) throws BussinessException;

    void delete(Long id);

    Optional<Person> findByCpf(String cpf);

    void save(Person person);
}

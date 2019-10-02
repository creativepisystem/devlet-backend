package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.PersonModel;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    BussinessException NON_UNIQUE_CPF_EXCEPTION = new BussinessException("There is a matching Cpf in use");
    BussinessException CPF_DOES_NOT_MATCH_ID_EXCEPTION = new BussinessException("The Cpf doesn't match the person Id");

    Optional<Person> findById(Long id);

    List<Person> findAll();

    Person create (PersonModel model) throws BussinessException;

    Person update (PersonModel model) throws BussinessException;

    void delete (Long id);

    Optional<Person> findByCpf(String cpf);
}

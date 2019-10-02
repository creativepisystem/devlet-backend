package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.PersonModel;
import br.com.creative.devlet.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    IntegrationService integrationService;

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Transactional
    @Override
    public Person create(PersonModel model) throws BussinessException {
        NON_UNIQUE_CPF_EXCEPTION.thrownIf(personRepository.findByCpf(model.getCpf().replaceAll("[^0-9]", "")).isPresent());
        integrationService.getAdressByZipCode(model.getZipCode());
        Person entity = convertModelToEntity(model);
        entity.setCpf(entity.getCpf().replaceAll("[^0-9]",""));
        entity.setZipCode(entity.getZipCode().replaceAll("[^0-9]",""));
        entity.setPhone(entity.getPhone().replaceAll("[^0-9]",""));
        return entity;
    }

    @Transactional
    @Override
    public Person update(PersonModel model) throws BussinessException {
        model.setCpf(model.getCpf().replaceAll("[^0-9]",""));
        model.setZipCode(model.getZipCode().replaceAll("[^0-9]",""));
        model.setPhone(model.getPhone().replaceAll("[^0-9]",""));
        Optional<Person> entity = personRepository.findByCpf(model.getCpf());
        CPF_DOES_NOT_MATCH_ID_EXCEPTION.thrownIf(entity.isPresent() && !entity.get().getId().equals(model.getId()));
        return personRepository.save(convertModelToEntity(model));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Person> person = findById(id);
        if(person.isPresent()){
            personRepository.delete(person.get());
        }
    }

    @Override
    public Optional<Person> findByCpf(String cpf) {
        return personRepository.findByCpf(cpf);
    }

    private Person convertModelToEntity(PersonModel model) {
        Person entity = new Person();
        if (model.getId() != null) {
            entity.setId(model.getId());
        }
        entity.setCity(model.getCity());
        entity.setCpf(model.getCpf());
        entity.setCountry(model.getCountry());
        entity.setName(model.getName());
        entity.setNeighborhood(model.getNeighborhood());
        entity.setNumber(model.getNumber());
        entity.setPhone(model.getPhone());
        entity.setState(model.getState());
        entity.setStreet(model.getStreet());
        entity.setZipCode(model.getZipCode());
        entity.setUser_id(model.getUser_id());
        entity.setEnterprise_id(model.getEnterprise_id());
        return entity;
    }
}
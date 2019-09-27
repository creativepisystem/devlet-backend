package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.model.EnterpriseModel;
import br.com.creative.devlet.repo.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public Optional<Enterprise> findById(Long id) {
        return enterpriseRepository.findById(id);
    }

    @Override
    public List<Enterprise> findAll() {
        return (List<Enterprise>) enterpriseRepository.findAll();
    }

    @Transactional
    @Override
    public Enterprise create(EnterpriseModel model) {
        return enterpriseRepository.save(convertModelToEntity(model));
    }

    @Transactional
    @Override
    public Enterprise update(EnterpriseModel model) {
        return enterpriseRepository.save(convertModelToEntity(model));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<Enterprise> enterprise = findById(id);
        if (enterprise.isPresent()) {
            enterpriseRepository.delete(enterprise.get());
        }
    }

    @Override
    public Enterprise findByCnpj(String cnpj) {
        return enterpriseRepository.findByCnpj(cnpj);
    }

    private Enterprise convertModelToEntity(EnterpriseModel model){
        Enterprise entity = new Enterprise();
        if(model.getId() != null){
            entity.setId(model.getId());
        }
        entity.setCity(model.getCity());
        entity.setCnpj(model.getCnpj());
        entity.setCountry(model.getCountry());
        entity.setEmail(model.getEmail());
        entity.setEnabled(model.getEnabled());
        entity.setName(model.getName());
        entity.setNeighborhood(model.getNeighborhood());
        entity.setNumber(model.getNumber());
        entity.setPhone(model.getPhone());
        entity.setState(model.getState());
        entity.setStreet(model.getStreet());
        entity.setType(model.getType());
        entity.setZipCode(model.getZipCode());
        return  entity;
    }
}

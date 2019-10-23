package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.EnterprisePostModel;
import br.com.creative.devlet.model.GetEnterpriseModel;
import br.com.creative.devlet.repo.EnterpriseRepository;
import br.com.creative.devlet.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IntegrationService integrationService;

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
    public Enterprise create(EnterprisePostModel model) throws BussinessException {
        NON_UNIQUE_CNPJ_EXCEPTION.thrownIf(enterpriseRepository.findByCnpj(model.getCnpj().replaceAll("[^0-9]", "")).isPresent());
        NON_UNIQUE_EMAIL_EXCEPTION.thrownIf(enterpriseRepository.findByEmail(model.getEmail()).isPresent());
        integrationService.getAdressByZipCode(model.getZipCode());
        Enterprise entity = convertModelToEntity(model);
        entity.setCnpj(entity.getCnpj().replaceAll("[^0-9]",""));
        entity.setZipCode(entity.getZipCode().replaceAll("[^0-9]",""));
        entity.setPhone(entity.getPhone().replaceAll("[^0-9]",""));


        return enterpriseRepository.save(entity);
    }

    @Transactional
    @Override
    public Enterprise update(EnterprisePostModel model) throws BussinessException {
        model.setCnpj(model.getCnpj().replaceAll("[^0-9]",""));
        model.setZipCode(model.getZipCode().replaceAll("[^0-9]",""));
        model.setPhone(model.getPhone().replaceAll("[^0-9]",""));
        Optional<Enterprise> entity = enterpriseRepository.findByCnpj(model.getCnpj());
        CNPJ_DOES_NOT_MATCH_ID_EXCEPTION.thrownIf(entity.isPresent() && !entity.get().getId().equals(model.getId()));
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
    public Optional<Enterprise> findByCnpj(String cnpj) {
        return enterpriseRepository.findByCnpj(cnpj);
    }

    @Override
    public Optional<Enterprise> findByEmail(String email){ return enterpriseRepository.findByEmail(email);}

    @Override
    public void save(Enterprise entity) {
        enterpriseRepository.save(entity);
    }

    private Enterprise convertModelToEntity(EnterprisePostModel model) {
        Enterprise entity = new Enterprise();
        if (model.getId() != null) {
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
        return entity;
    }

    @Override
    public GetEnterpriseModel convertEntityToGetEnterpriseModel(Enterprise entity) {
        GetEnterpriseModel model = new GetEnterpriseModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setType(entity.getType());
        return model;
    }
}

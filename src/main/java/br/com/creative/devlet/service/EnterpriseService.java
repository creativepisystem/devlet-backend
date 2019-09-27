package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.model.EnterpriseModel;

import java.util.List;
import java.util.Optional;

public interface EnterpriseService {
    Optional<Enterprise> findById(Long id);

    List<Enterprise> findAll();

    Enterprise create(EnterpriseModel model);

    Enterprise update(EnterpriseModel model);

    void delete(Long id);

    Enterprise findByCnpj(String cnpj);
}

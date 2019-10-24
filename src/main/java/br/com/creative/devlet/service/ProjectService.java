package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Project;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetProjectModel;
import br.com.creative.devlet.model.PostProjectModel;
import br.com.creative.devlet.security.SecurityUser;

import java.util.List;

public interface ProjectService {
    BussinessException PROJECT_DOESNT_EXISTS_EXCEPTION = new BussinessException("The selected project doesn't exists");
    BussinessException TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The selected team and user are not in the same enterprise");
    BussinessException PROJECT_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The selected project and user are not in the same enterprise");

    GetProjectModel findById(Long id) throws BussinessException;

    List<GetProjectModel> findAll();

    List<GetProjectModel> findAllProjectsFromClient(Long clientId);

    Project create(PostProjectModel model, SecurityUser user) throws BussinessException;

    Project update(PostProjectModel model, SecurityUser user) throws BussinessException;

    void delete(Long id, SecurityUser user) throws BussinessException;
}

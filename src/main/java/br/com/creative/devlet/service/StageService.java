package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Stage;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetStageModel;
import br.com.creative.devlet.model.PostStageModel;
import br.com.creative.devlet.model.PutStageModel;
import br.com.creative.devlet.security.SecurityUser;

import java.util.List;

public interface StageService {
    BussinessException STAGE_DOESNT_EXISTS_EXCEPTION = new BussinessException("The selected stage doesn't exists");
    BussinessException PROJECT_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The selected project and the user are not in the same enterprise");
    BussinessException PROJECT_DOESNT_EXISTS_EXCEPTION = new BussinessException("The selected project doesn't exists");
    BussinessException STAGE_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The selected stage and the user are not in the same enterprise");

    GetStageModel findById(Long id) throws BussinessException;

    List<GetStageModel> findAll();

    List<GetStageModel> findStagesOfProject(Long projectId);

    Stage create(PostStageModel model, SecurityUser user) throws BussinessException;

    Stage update(PutStageModel model, SecurityUser user) throws BussinessException;

    void delete(Long id, SecurityUser user) throws BussinessException;
}

package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Activity;
import br.com.creative.devlet.entity.Stage;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetStageModel;
import br.com.creative.devlet.model.PostStageModel;
import br.com.creative.devlet.model.PutStageModel;
import br.com.creative.devlet.repo.StageRepository;
import br.com.creative.devlet.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StageServiceImpl implements StageService {
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EnterpriseService enterpriseService;

    @Override
    public GetStageModel findById(Long id) throws BussinessException {
        Optional<Stage> entity = stageRepository.findById(id);
        STAGE_DOESNT_EXISTS_EXCEPTION.thrownIf(!entity.isPresent());
        return convertEntityToGetStageModel(entity.get());
    }

    @Override
    public Stage findEntityById(Long id) {
        return stageRepository.findById(id).get();
    }

    @Override
    public List<GetStageModel> findAll() {
        List<Stage> stages = (List<Stage>) stageRepository.findAll();
        return stages.stream().map(this::convertEntityToGetStageModel).collect(Collectors.toList());
    }

    @Override
    public List<GetStageModel> findStagesOfProject(Long projectId) {
        List<Stage> stages = stageRepository.findStagesOfProject(projectId);
        return stages.stream().map(this::convertEntityToGetStageModel).collect(Collectors.toList());
    }

    @Override
    public Stage create(PostStageModel model, SecurityUser user) throws BussinessException {
        PROJECT_DOESNT_EXISTS_EXCEPTION.thrownIf(projectService.findById(model.getProjectId())==null);
        PROJECT_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                projectService.findById(model.getProjectId()).getEnterprise().getId()));
        return stageRepository.save(convertPostStageModelToEntity(model,user));
    }

    @Override
    public Stage update(PutStageModel model, SecurityUser user) throws BussinessException {
        PROJECT_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                stageRepository.findById(model.getId()).get().getProject().getEnterprise().getId()));
        STAGE_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                stageRepository.findById(model.getId()).get().getEnterprise().getId()));
        return stageRepository.save(convertPutStageModelToEntity(model));
    }

    @Override
    public void delete(Long id, SecurityUser user) throws BussinessException {
        Optional<Stage> entity = stageRepository.findById(id);
        STAGE_DOESNT_EXISTS_EXCEPTION.thrownIf(!entity.isPresent());
        Stage stage = entity.get();
        STAGE_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(user.getEnterprise().getId().equals(
                stage.getEnterprise().getId()));
        stageRepository.delete(stage);
    }

    public GetStageModel convertEntityToGetStageModel(Stage entity) {
        GetStageModel model = new GetStageModel();
        model.setDate(entity.getDate());
        model.setProject(projectService.convertEntityToGetProjectModel(entity.getProject()));
        model.setName(entity.getName());
        model.setId(entity.getId());
        model.setEnterprise(enterpriseService.convertEntityToGetEnterpriseModel(entity.getEnterprise()));
        model.setDescription(entity.getDescription());
        return model;
    }

    public Stage convertPostStageModelToEntity(PostStageModel model, SecurityUser user){
        Stage entity = new Stage();
        entity.setDescription(model.getDescription());
        entity.setEnterprise(user.getEnterprise());
        entity.setProject(projectService.findEntityById(model.getProjectId()));
        entity.setName(model.getName());
        return entity;
    }

    public Stage convertPutStageModelToEntity(PutStageModel model){
        Stage entity = new Stage();
        entity.setName(model.getName());
        entity.setId(model.getId());
        entity.setDescription(model.getDescription());
        entity.setDate(model.getDate());
        return entity;
    }
}

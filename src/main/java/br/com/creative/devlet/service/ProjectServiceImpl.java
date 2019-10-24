package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Project;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetProjectModel;
import br.com.creative.devlet.model.PostProjectModel;
import br.com.creative.devlet.repo.ProjectRepository;
import br.com.creative.devlet.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private TeamService teamService;


    @Override
    public GetProjectModel findById(Long id) throws BussinessException {
        Optional<Project> project = projectRepository.findById(id);
        PROJECT_DOESNT_EXISTS_EXCEPTION.thrownIf(!project.isPresent());
        return convertEntityToGetProjectModel(project.get());
    }

    @Override
    public List<GetProjectModel> findAll() {
        List<Project> projects = (List<Project>) projectRepository.findAll();
        return projects.stream().map(this::convertEntityToGetProjectModel).collect(Collectors.toList());
    }

    @Override
    public List<GetProjectModel> findAllProjectsFromClient(Long clientId) {
        List<Project> projects = projectRepository.findAllProjectsFromClient(clientId);
        return projects.stream().map(this::convertEntityToGetProjectModel).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Project create(PostProjectModel model, SecurityUser user) throws BussinessException{
        TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(teamService.findById((model.getTeamId())).getId()));
        return projectRepository.save(convertPostProjectModelToEntity(model, user));
    }

    @Transactional
    @Override
    public Project update(PostProjectModel model, SecurityUser user) throws BussinessException{
        TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(teamService.findById((model.getTeamId())).getId()));
        return projectRepository.save(convertPostProjectModelToEntity(model, user));
    }

    @Transactional
    @Override
    public void delete(Long id,SecurityUser user) throws BussinessException{
        Optional<Project> entity = projectRepository.findById(id);
        PROJECT_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(user.getEnterprise().getId().equals(projectRepository.findById(id).get().getEnterprise().getId()));
        if (entity.isPresent()) {
            projectRepository.delete(entity.get());
        }
    }

    public GetProjectModel convertEntityToGetProjectModel(Project entity){
        GetProjectModel model = new GetProjectModel();
        model.setId(entity.getId());
        model.setBudget(entity.getBudget());
        model.setClient(enterpriseService.convertEntityToGetEnterpriseModel(entity.getClient()));
        model.setDescription(entity.getDescription());
        model.setEnterprise(enterpriseService.convertEntityToGetEnterpriseModel(entity.getEnterprise()));
        model.setEstimatedHours(entity.getEstimatedHours());
        model.setName(entity.getName());
        model.setTeam(teamService.convertEntityToGetTeamModel(entity.getTeam()));
        return model;
    }

    public Project convertPostProjectModelToEntity(PostProjectModel model, SecurityUser user) {
        Project entity = new Project();
        if(model.getId()!=null){
            entity.setId(model.getId());
        }
        entity.setBudget(model.getBudget());
        entity.setClient(enterpriseService.findById(model.getClientId()).get());
        entity.setDescription(model.getDescription());
        entity.setEnterprise(user.getEnterprise());
        entity.setEstimatedHours(model.getEstimatedHours());
        entity.setTeam(teamService.findEntityById((model.getClientId())));
        entity.setName(model.getName());
        return entity;
    }
}

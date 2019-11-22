package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Activity;
import br.com.creative.devlet.enums.EnumActivityStatus;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.*;
import br.com.creative.devlet.repo.ActivityRepository;
import br.com.creative.devlet.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private StageService stageService;
    @Autowired
    private EnterpriseService enterpriseService;


    @Override
    public GetActivityModel findById(Long id) throws BussinessException {
        Optional<Activity> entity = activityRepository.findById(id);
        ACTIVITY_DOENST_EXISTS_EXCEPTION.thrownIf(!entity.isPresent());
        return convertEntityToGetActivityModel(entity.get());
    }

    @Override
    public List<GetActivityModel> findAll(){
        List<Activity> activities = (List<Activity>) activityRepository.findAll();
        return activities.stream().map(this::convertEntityToGetActivityModel).collect(Collectors.toList());
    }

    @Override
    public List<GetActivityModel> findActivitiesOfPerson(Long personId) throws BussinessException {
        PERSON_DOENST_EXISTS_EXCEPTION.thrownIf(!personService.findById(personId).isPresent());
        List<Activity> activities = activityRepository.findActivitiesOfPerson(personId);
        NO_ACTIVITIES_IN_LIST_EXCEPTION.thrownIf(activities.isEmpty());
        return activities.stream().map(this::convertEntityToGetActivityModel).collect(Collectors.toList());
    }

    @Override
    public List<GetActivityModel> findActivitiesOfStage(Long stageId) throws BussinessException {
        STAGE_DOENST_EXISTS_EXCEPTION.thrownIf(stageService.findById(stageId)==null);
        List<Activity> activities = activityRepository.findActivitiesOfStage(stageId);
        NO_ACTIVITIES_IN_LIST_EXCEPTION.thrownIf(activities.isEmpty());
        return activities.stream().map(this::convertEntityToGetActivityModel).collect(Collectors.toList());
    }

    @Override
    public Activity create(PostActivityModel model, SecurityUser user) throws BussinessException {
        PERSON_DOENST_EXISTS_EXCEPTION.thrownIf(!personService.findById(model.getPersonId()).isPresent());
        STAGE_DOENST_EXISTS_EXCEPTION.thrownIf(stageService.findById(model.getStageId()) == null);
        PERSON_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                personService.findById(model.getPersonId()).get().getId()));
        STAGE_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                stageService.findById(model.getStageId()).getId()));
        return activityRepository.save(convertPostActivityModelToEntity(model,user));
    }

    @Override
    public Activity update(PutActivityModel model, SecurityUser user) throws BussinessException {
        PERSON_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                personService.findById(model.getPersonId()).get().getId()));
        STAGE_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                stageService.findById(model.getStageId()).getId()));
        ACTIVITY_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                activityRepository.findById(model.getId()).get().getEnterprise().getId()));
        return activityRepository.save(convertPutActivityModelToEntity(model));
    }

    @Override
    public void updateActivityStatus(EnumActivityStatus status, Long id, SecurityUser user) throws BussinessException {
        Optional<Activity> entity = activityRepository.findById(id);
        ACTIVITY_DOENST_EXISTS_EXCEPTION.thrownIf(!entity.isPresent());
        Activity activity = entity.get();
        ACTIVITY_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                activity.getEnterprise().getId()));
        activity.setStatus(status);
        activityRepository.save(activity);
    }


    @Override
    public void delete(Long id, SecurityUser user) throws BussinessException {
        Optional<Activity> entity = activityRepository.findById(id);
        ACTIVITY_DOENST_EXISTS_EXCEPTION.thrownIf(!entity.isPresent());
        Activity activity = entity.get();
        ACTIVITY_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!user.getEnterprise().getId().equals(
                activity.getEnterprise().getId()));
        activityRepository.delete(activity);
    }

    public GetActivityModel convertEntityToGetActivityModel(Activity entity) {
        GetActivityModel model = new GetActivityModel();
        model.setCheckList(entity.getChecklist());
        model.setConclusionDate(entity.getConclusionDate());
        model.setDescription(entity.getDescription());
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setStatus(entity.getStatus());
        model.setOpeningDate(entity.getOpeningDate());
        model.setStage(stageService.convertEntityToGetStageModel(entity.getStage()));
        model.setPerson(personService.convertEntityToGetPersonModel(entity.getPerson()));
        model.setEnterprise(enterpriseService.convertEntityToGetEnterpriseModel(entity.getEnterprise()));
        return model;
    }

    public Activity convertPostActivityModelToEntity(PostActivityModel model,SecurityUser user){
        Activity entity = new Activity();
        entity.setChecklist(model.getCheckList());
        entity.setConclusionDate(model.getConclusionDate());
        entity.setDescription(model.getDescription());
        entity.setEnterprise(enterpriseService.findById(user.getEnterprise().getId()).get());
        entity.setOpeningDate(model.getOpeningDate());
        entity.setPerson(personService.findById(model.getPersonId()).get());
        entity.setStage(stageService.findEntityById(model.getStageId()));
        entity.setTitle(model.getTitle());
        return entity;
    }

    public Activity convertPutActivityModelToEntity(PutActivityModel model){
        Activity entity = activityRepository.findById(model.getId()).get();
        entity.setId(model.getId());
        entity.setTitle(model.getTitle());
        entity.setChecklist(model.getCheckList());
        entity.setConclusionDate(model.getConclusionDate());
        entity.setDescription(model.getDescription());
        entity.setOpeningDate(model.getOpeningDate());
        entity.setPerson(personService.findById(model.getPersonId()).get());
        entity.setStage(stageService.findEntityById(model.getStageId()));
        return entity;
    }
}

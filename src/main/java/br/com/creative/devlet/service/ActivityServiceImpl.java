package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Activity;
import br.com.creative.devlet.enums.EnumActivityStatus;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetActivityModel;
import br.com.creative.devlet.model.PostActivityModel;
import br.com.creative.devlet.model.PutStageModel;
import br.com.creative.devlet.repo.ActivityRepository;
import br.com.creative.devlet.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public List<GetActivityModel> findAll() {
        return null;
    }

    @Override
    public List<GetActivityModel> findActivitiesOfPerson(Long personId) throws BussinessException {
        return null;
    }

    @Override
    public List<GetActivityModel> findActivitiesOfStage(Long stageId) throws BussinessException {
        return null;
    }

    @Override
    public Activity create(PostActivityModel model, SecurityUser user) throws BussinessException {
        return null;
    }

    @Override
    public Activity update(PutStageModel model, SecurityUser user) throws BussinessException {
        return null;
    }

    @Override
    public void updateActivityStatus(EnumActivityStatus status, Long id) throws BussinessException {

    }

    @Override
    public void delete(Long id, SecurityUser user) throws BussinessException {

    }
}

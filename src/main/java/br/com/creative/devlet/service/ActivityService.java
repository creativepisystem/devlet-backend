package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Activity;
import br.com.creative.devlet.enums.EnumActivityStatus;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetActivityModel;
import br.com.creative.devlet.model.PostActivityModel;
import br.com.creative.devlet.model.PutActivityModel;
import br.com.creative.devlet.model.PutStageModel;
import br.com.creative.devlet.security.SecurityUser;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    BussinessException STAGE_DOENST_EXISTS_EXCEPTION = new BussinessException("The selected stage doesn't exists");
    BussinessException PERSON_DOENST_EXISTS_EXCEPTION = new BussinessException("The selected person doesn't exists");
    BussinessException ACTIVITY_DOENST_EXISTS_EXCEPTION = new BussinessException("The selected activity doesn't exists");
    BussinessException STAGE_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The selected stage and user are not in the same enterprise");
    BussinessException PERSON_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The selected person and the user are not in the same enterprise");
    BussinessException ACTIVITY_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The selected activity and the user are not in the same enterprise");
    BussinessException NO_ACTIVITIES_IN_LIST_EXCEPTION = new BussinessException("There aren't activities in the list");

    GetActivityModel findById(Long id) throws BussinessException;

    List<GetActivityModel> findAll();

    List<GetActivityModel> findActivitiesOfPerson(Long personId) throws BussinessException;

    List<GetActivityModel> findActivitiesOfStage(Long stageId) throws BussinessException;

    Activity create(PostActivityModel model, SecurityUser user) throws BussinessException;

    Activity update(PutActivityModel model, SecurityUser user) throws BussinessException;

    void updateActivityStatus(EnumActivityStatus status,Long id,SecurityUser user) throws BussinessException;

    void delete(Long id, SecurityUser user) throws BussinessException;

}

package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Activity;
import br.com.creative.devlet.enums.EnumActivityStatus;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetActivityModel;
import br.com.creative.devlet.model.PostActivityModel;
import br.com.creative.devlet.model.PutStageModel;
import br.com.creative.devlet.security.SecurityUser;

import java.util.List;

public interface ActivityService {

    GetActivityModel findById(Long id) throws BussinessException;

    List<GetActivityModel> findAll();

    List<GetActivityModel> findActivitiesOfPerson(Long personId) throws BussinessException;

    List<GetActivityModel> findActivitiesOfStage(Long stageId) throws BussinessException;

    Activity create(PostActivityModel model, SecurityUser user) throws BussinessException;

    Activity update(PutStageModel model, SecurityUser user) throws BussinessException;

    void updateActivityStatus(EnumActivityStatus status, Long id) throws BussinessException;

    void delete(Long id, SecurityUser user) throws BussinessException;

}

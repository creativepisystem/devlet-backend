package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.GetTeamModel;
import br.com.creative.devlet.model.PersonToTeamModel;
import br.com.creative.devlet.model.TeamModel;
import br.com.creative.devlet.security.SecurityUser;

import java.util.List;

public interface TeamService {
    BussinessException PERSON_DOESNT_EXIST_EXCEPTION = new BussinessException("The selected person doesn't exist");
    BussinessException TEAM_DOESNT_EXIST_EXCEPTION = new BussinessException("The selected team doesn't exist");
    BussinessException Enterprise_DOESNT_EXIST_EXCEPTION = new BussinessException("The selected enterprise doesn't exist");
    BussinessException PERSON_ALREADY_IN_TEAM_EXCEPTION = new BussinessException("The selected person is already inside the team");
    BussinessException TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The team and the user are not in the same enterprise");
    BussinessException PERSON_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION = new BussinessException("The person and the user are not in the same enterprise");
    BussinessException THERE_ARE_NO_PEOPLE_IN_THE_TEAM_EXCEPTION = new BussinessException("The team doesn't have any people in it");
    BussinessException PERSON_IS_NOT_IN_TEAM_EXCEPTION = new BussinessException("The selected person is not in the team");
    BussinessException TEAM_OR_PERSON_ID_ARE_INVALID_EXCEPTION = new BussinessException("The Person and Team id can't be a null value");


    GetTeamModel findById(Long id) throws BussinessException;

    void addPersonToTeam(PersonToTeamModel model, SecurityUser user) throws BussinessException;

    List<GetTeamModel> findAll();

    Team create(TeamModel model, SecurityUser user) throws BussinessException;

    Team update(TeamModel model,SecurityUser user) throws BussinessException;

    void delete(Long id,SecurityUser user) throws BussinessException;

    void removePersonFromTeam(PersonToTeamModel model,SecurityUser user) throws BussinessException;
}

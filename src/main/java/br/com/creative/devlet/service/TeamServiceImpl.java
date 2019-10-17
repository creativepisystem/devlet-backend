package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Enterprise;
import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.*;
import br.com.creative.devlet.repo.TeamRepository;
import br.com.creative.devlet.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private EnterpriseService enterpriseService;


    @Override
    public GetTeamModel findById(Long id) throws BussinessException {
        Optional<Team> entity = teamRepository.findById(id);
        TEAM_DOESNT_EXIST_EXCEPTION.thrownIf(!entity.isPresent());
        return convertEntityToGetTeamModel(entity.get());
    }

    @Transactional
    @Override
    public void addPersonToTeam(PersonToTeamModel model, SecurityUser user) throws BussinessException {
        Long idTeam = model.getIdTeam(), idPerson = model.getIdPerson();
        TEAM_OR_PERSON_ID_ARE_INVALID_EXCEPTION.thrownIf( idPerson < 1 || idTeam < 1);
        Optional<Person> person = personService.findById(idPerson);
        PERSON_DOESNT_EXIST_EXCEPTION.thrownIf(!person.isPresent());
        PERSON_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(person.get().getEnterprise(enterpriseService.findById(user.getEnterprise().getId())).isEmpty());
        Optional<Team> entity = teamRepository.findById(idTeam);
        TEAM_DOESNT_EXIST_EXCEPTION.thrownIf(!entity.isPresent());
        TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!entity.get().getEnterprise().equals(user.getEnterprise()));

        Team team = entity.get();

        if (team.getPeople() == null) {
            List<Person> people = new ArrayList<>();
            people.add(person.get());
            team.setPeople(people);
        } else {
            PERSON_ALREADY_IN_TEAM_EXCEPTION.thrownIf(team.getPeople().contains(person.get()));
            team.getPeople().add(person.get());
        }
        teamRepository.save(team);
    }

    @Override
    public List<GetTeamModel> findAll() {
        List<Team> teams = (List<Team>) teamRepository.findAll();
        return teams.stream().map(this::convertEntityToGetTeamModel).collect(Collectors.toList());
    }


    @Transactional
    @Override
    public Team create(TeamModel model, SecurityUser user) throws BussinessException {
        Enterprise_DOESNT_EXIST_EXCEPTION.thrownIf(!enterpriseService.findById(model.getIdEnterprise()).isPresent());
//        TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(
//                !model.getIdEnterprise().equals(user.getEnterprise().getId()));
        return teamRepository.save(convertModelToEntity(model));
    }

    @Transactional
    @Override
    public Team update(TeamModel model, SecurityUser user) throws BussinessException {
        TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(
                !model.getIdEnterprise().equals(user.getEnterprise().getId()));
        return teamRepository.save(convertModelToEntity(model));
    }

    @Transactional
    @Override
    public void delete(Long id, SecurityUser user) throws BussinessException {
        Optional<Team> team = teamRepository.findById(id);
        TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(
                !team.get().getEnterprise().getId().equals(user.getEnterprise().getId()));
        if (team.isPresent()) {
            teamRepository.delete(team.get());
        }
    }

    @Override
    public void removePersonFromTeam(PersonToTeamModel model, SecurityUser user) throws BussinessException {
        Long idTeam = model.getIdTeam(), idPerson = model.getIdPerson();
        TEAM_OR_PERSON_ID_ARE_INVALID_EXCEPTION.thrownIf( idPerson < 1 || idTeam < 1);
        Optional<Person> person = personService.findById(idPerson);
        PERSON_DOESNT_EXIST_EXCEPTION.thrownIf(!person.isPresent());
        PERSON_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(person.get().getEnterprise(enterpriseService.findById(user.getEnterprise().getId())).isEmpty());
        Optional<Team> entity = teamRepository.findById(idTeam);
        TEAM_DOESNT_EXIST_EXCEPTION.thrownIf(!entity.isPresent());
        TEAM_AND_USER_NOT_IN_SAME_ENTERPRISE_EXCEPTION.thrownIf(!entity.get().getEnterprise().equals(user.getEnterprise()));

        Team team = entity.get();

        THERE_ARE_NO_PEOPLE_IN_THE_TEAM_EXCEPTION.thrownIf(team.getPeople() == null);
        PERSON_IS_NOT_IN_TEAM_EXCEPTION.thrownIf(!team.getPeople().contains(person));

        team.getPeople().remove(person);

        teamRepository.save(team);
    }

    private Team convertModelToEntity(TeamModel model) {
        Team entity = new Team();
        if (model.getId() != null) {
            entity.setId(model.getId());
        }
        entity.setName(model.getName());
        entity.setEnterprise(enterpriseService.findById(model.getIdEnterprise()).get());
        return entity;
    }

    private GetTeamModel convertEntityToGetTeamModel(Team entity) {
        GetTeamModel model = new GetTeamModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPeople(entity.getPeople().stream().map(person -> {
            GetPersonModel personModel = new GetPersonModel();
            personModel.setId(person.getId());
            personModel.setName(person.getName());
            return personModel;
        }).collect(Collectors.toList()));
        model.setEnterprise(enterpriseService.convertEntityToGetEnterpriseModel(entity.getEnterprise()));
        return model;
    }

}
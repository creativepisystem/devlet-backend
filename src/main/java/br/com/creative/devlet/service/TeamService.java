package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.TeamModel;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    BussinessException PERSON_ALREADY_IN_TEAM_EXCEPTION = new BussinessException("This person is already in the team");

    Optional<Team> findById(Long id);

    Optional<Person> findPersonInTeam(Long person_id,Long team_id);

    List<Team> findAll();

    List<Person> findPeopleInTeam(Long id);

    void insertPeopleIntoTeam(Long person_id,Long team_id) throws BussinessException;

    Team create(TeamModel model) throws BussinessException;

    Team update(TeamModel model) throws BussinessException;

    void delete(Long id);
}

package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.TeamModel;
import br.com.creative.devlet.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public Optional<Person> findPersonInTeam(Long person_id, Long team_id) {
        return teamRepository.findPersonInTeam(person_id,team_id);
    }

    @Override
    public List<Person> findPeopleInTeam(Long id) {
        return teamRepository.findPeopleInTeam(id);
    }

    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public void insertPeopleIntoTeam(Long person_id, Long team_id) throws BussinessException {
        PERSON_ALREADY_IN_TEAM_EXCEPTION.thrownIf(findPersonInTeam(person_id,team_id).isPresent());
        teamRepository.insertPersonIntoTeam(person_id,team_id);
    }

    @Transactional
    @Override
    public Team create(TeamModel model) throws BussinessException {
        return teamRepository.save(convertModelToEntity(model));
    }

    @Transactional
    @Override
    public Team update(TeamModel model) throws BussinessException {
        return teamRepository.save(convertModelToEntity(model));
    }

    @Override
    public void delete(Long id) {
        Optional<Team> team = findById(id);
        if (team.isPresent()) {
            teamRepository.delete(team.get());
        }
    }

    private Team convertModelToEntity(TeamModel model) {
        Team entity = new Team();
        if (model.getId() != null) {
            entity.setId(model.getId());
        }
        entity.setName(model.getName());
        entity.setDate(model.getDate());
        return entity;
    }
}

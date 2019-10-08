package br.com.creative.devlet.service;

import br.com.creative.devlet.compositekeys.TeamPrimaryKey;
import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.TeamModel;
import br.com.creative.devlet.repo.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Optional<Team> findById(TeamPrimaryKey teamPrimaryKey) {
        return teamRepository.findById(teamPrimaryKey);
    }

    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepository.findAll();
    }

    @Transactional
    @Override
    public Team create(TeamModel model) throws BussinessException {
        return null;
    }

    @Override
    public Team update(TeamModel model) throws BussinessException {
        return null;
    }

    @Override
    public void delete(Long id, String name) {

    }
}

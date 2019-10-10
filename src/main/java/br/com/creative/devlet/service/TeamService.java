package br.com.creative.devlet.service;

import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.TeamModel;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    BussinessException TEAM_DOESNT_EXIST = new BussinessException("This team doesn't exist");

    Optional<Team> findById(Long id);

    List<Team> findAll();

    Team create(TeamModel model) throws BussinessException;

    Team update(TeamModel model) throws BussinessException;

    void delete(Long id);
}

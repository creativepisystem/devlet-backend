package br.com.creative.devlet.service;

import br.com.creative.devlet.compositekeys.TeamPrimaryKey;
import br.com.creative.devlet.entity.Team;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.TeamModel;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Optional<Team> findById(TeamPrimaryKey teamPrimaryKey);

    List<Team> findAll();

    Team create(TeamModel model) throws BussinessException;

    Team update(TeamModel model) throws BussinessException;

    void delete(Long id, String name);
}

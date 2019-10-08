package br.com.creative.devlet.repo;

import br.com.creative.devlet.compositekeys.TeamPrimaryKey;
import br.com.creative.devlet.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {
    Optional<Team> findById(TeamPrimaryKey teamPrimaryKey);
}

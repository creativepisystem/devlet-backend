package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {
}

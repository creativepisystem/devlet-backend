package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {
    @Query(value = "insert into person_team(person_id,team_id) values(1?,2?)",nativeQuery = true)
    public void insertPersonIntoTeam(Long person_id, Long team_id);
    @Query(value = "select * from person where id in(select person_id from person_team where team_id = 1?)", nativeQuery = true)
    public List<Person> findPeopleInTeam(Long id);
    @Query(value = "select * from person where id in(select person_id from person_team where person_id = 1? and team_id = 2?)")
    public Optional<Person> findPersonInTeam(Long person_id, Long team_id);
}

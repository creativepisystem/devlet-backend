package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Query(value = "select * from project where client_id = 1?")
    List<Project> findAllProjectsFromClient(Long clientId);
}

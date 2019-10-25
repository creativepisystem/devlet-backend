package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Query(value = "select * from project where client_id = ?1",nativeQuery = true)
    List<Project> findAllProjectsFromClient(Long clientId);
}

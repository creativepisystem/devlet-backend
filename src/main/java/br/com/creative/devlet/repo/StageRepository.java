package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Stage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends CrudRepository<Stage, Long> {
    @Query(value = "select * from stage where project_id = ?1", nativeQuery = true)
    List<Stage> findStagesOfProject(Long projectId);
}

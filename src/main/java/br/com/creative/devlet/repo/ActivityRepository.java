package br.com.creative.devlet.repo;

import br.com.creative.devlet.entity.Activity;
import br.com.creative.devlet.enums.EnumActivityStatus;
import br.com.creative.devlet.model.GetActivityModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity,Long> {
    @Query(value = "select * from activity where person_id = ?1",nativeQuery = true)
    List<Activity> findActivitiesOfPerson(Long personId);

    @Query(value = "select * from activity where stage_id = ?1",nativeQuery = true)
    List<Activity> findActivitiesOfStage(Long stageId);
}

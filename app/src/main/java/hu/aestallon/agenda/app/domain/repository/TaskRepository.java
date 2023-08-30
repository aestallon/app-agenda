package hu.aestallon.agenda.app.domain.repository;

import hu.aestallon.agenda.app.domain.model.TaskEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

  @Query("select t.created_at from task_item t where t.id = :id")
  Optional<LocalDateTime> findCreationDateById(Long id);

}

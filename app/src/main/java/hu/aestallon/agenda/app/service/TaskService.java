package hu.aestallon.agenda.app.service;

import hu.aestallon.agenda.app.domain.model.TaskEntity;
import hu.aestallon.agenda.app.domain.repository.TaskRepository;
import hu.aestallon.agenda.app.rest.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

  private final TaskRepository taskRepository;

  private static Task entityToDto(TaskEntity e) {
    return new Task()
        .id(e.id())
        .title(e.title())
        .description(e.description())
        .completed(e.completed())
        .important(e.important());
  }

  private static TaskEntity dtoToEntity(Task t) {
    return dtoToEntity(t, LocalDateTime.now());
  }

  private static TaskEntity dtoToEntity(Task t, LocalDateTime createdAt) {
    Objects.requireNonNull(t, "task cannot be null!");
    Objects.requireNonNull(createdAt, "creation date cannot be null!");

    final var title = t.getTitle();
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("Title cannot be null or empty!");
    }

    return new TaskEntity(
        t.getId(),
        title,
        t.getDescription(),
        Boolean.TRUE.equals(t.getCompleted()),
        Boolean.TRUE.equals(t.getImportant()),
        createdAt);
  }

  public List<Task> getAllTasks() {
    return Streamable.of(taskRepository.findAll()).stream()
        .map(TaskService::entityToDto)
        .toList();
  }

  public Task createTask(Task task) {
    final var e = dtoToEntity(task);
    return entityToDto(taskRepository.save(e));
  }

  public Optional<Task> updateTask(Long taskId, Task task) {
    Objects.requireNonNull(taskId, "taskId cannot be null!");
    Objects.requireNonNull(task, "task cannot be null!");

    if (task.getId() != null && !taskId.equals(task.getId())) {
      throw new IllegalArgumentException("taskId mismatch on update!");
    }

    return taskRepository
        .findCreationDateById(taskId)
        .map(creationDate -> dtoToEntity(task.id(taskId), creationDate))
        .map(taskRepository::save)
        .map(TaskService::entityToDto);

  }

  public boolean deleteTask(Long taskId) {
    Objects.requireNonNull(taskId, "taskId cannot be null!");

    taskRepository.deleteById(taskId);
    return true;
  }

}

package hu.aestallon.agenda.app.rest.impl;

import hu.aestallon.agenda.app.rest.api.AgendaApiDelegate;
import hu.aestallon.agenda.app.rest.model.Task;
import hu.aestallon.agenda.app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AgendaApiDelegateImpl implements AgendaApiDelegate {

  private final TaskService taskService;

  @Override
  public ResponseEntity<Task> createTask(Task task) {
    return ResponseEntity.ok(taskService.createTask(task));
  }

  @Override
  public ResponseEntity<Void> deleteTask(Long id) {
    if (taskService.deleteTask(id)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Override
  public ResponseEntity<List<Task>> getAllTasks() {
    return ResponseEntity.ok(taskService.getAllTasks());
  }

  @Override
  public ResponseEntity<Task> updateTask(Long id, Task task) {
    return taskService
        .updateTask(id, task)
        .map(ResponseEntity::ok)
        .orElseGet(ResponseEntity.notFound()::build);
  }

}

package hu.aestallon.agenda.app.service;

import hu.aestallon.agenda.app.domain.model.TaskEntity;
import hu.aestallon.agenda.app.domain.repository.TaskRepository;
import hu.aestallon.agenda.app.rest.model.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskServiceTest {

  private static final LocalDateTime BASE_DATE_TIME   = LocalDateTime.of(
      LocalDate.of(2023, 1, 1),
      LocalTime.of(1, 0, 0)
  );
  private static final List<TaskEntity> EMPTY_LIST    = Collections.emptyList();
  private static final List<TaskEntity> LIST_OF_THREE = List.of(
      new TaskEntity(1L, "Title 1", "Description 1", false, false, BASE_DATE_TIME),
      new TaskEntity(2L, "Title 2", "Description 2", false, false, BASE_DATE_TIME.plusHours(1L)),
      new TaskEntity(3L, "Title 3", "Description 3", false, false, BASE_DATE_TIME.plusHours(2L))
  );

  private List<TaskEntity> mockEntities;
  private TaskRepository   taskRepository;
  private TaskService      taskService;

  @BeforeEach
  void beforeEach() {
    taskRepository = Mockito.mock(TaskRepository.class);
    taskService = new TaskService(taskRepository);
    mockEntities = new ArrayList<>();
  }

  @AfterEach
  void afterEach() {
    taskService = null;
    taskRepository = null;
  }

  @Test
  @DisplayName("Task service returns no tasks from empty repository")
  void testOnEmptyRepository() {
    mockEntities.addAll(EMPTY_LIST);
    Mockito.when(taskRepository.findAll()).thenReturn(mockEntities);

    assertThat(taskService.getAllTasks())
        .isNotNull()
        .isEmpty();
  }

  @Test
  @DisplayName("Task service returns one tasks after a task was added to an empty repository")
  void savedTaskShouldBeReturnedForConsecutiveFindAll() {
    mockEntities.addAll(EMPTY_LIST);
    Mockito.when(taskRepository.findAll()).thenReturn(mockEntities);
    Mockito.when(taskRepository.save(Mockito.any(TaskEntity.class))).thenAnswer(invocation -> {
      final TaskEntity arg = invocation.getArgument(0, TaskEntity.class);
      final TaskEntity mockSaveResult =
          new TaskEntity(99L, arg.title(), arg.description(), arg.completed(), arg.important(),
              BASE_DATE_TIME);
      mockEntities.add(mockSaveResult);
      return mockSaveResult;
    });

    final Task testTask = new Task()
        .title("Test title")
        .description("Test description");
    assertThat(testTask)
        .returns(Boolean.FALSE, Task::getCompleted)
        .returns(Boolean.FALSE, Task::getImportant);

    final Task result = taskService.createTask(testTask);
    assertThat(result)
        .returns(99L, Task::getId)
        .returns("Test title", Task::getTitle)
        .returns("Test description", Task::getDescription)
        .returns(Boolean.FALSE, Task::getCompleted)
        .returns(Boolean.FALSE, Task::getImportant);

    assertThat(mockEntities)
        .isNotEmpty()
        .hasSize(1);
    assertThat(mockEntities.get(0).createdAt()).isNotNull();

    assertThat(taskService.getAllTasks())
        .isNotNull()
        .isNotEmpty()
        .hasSize(1)
        .allSatisfy(t -> assertThat(t).isEqualTo(result));


  }

}

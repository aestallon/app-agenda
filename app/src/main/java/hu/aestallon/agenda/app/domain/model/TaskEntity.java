package hu.aestallon.agenda.app.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("task_item")
public record TaskEntity(
    @Id Long id,
    @Column("title") String title,
    @Column("descr") String description,
    @Column("completed") boolean completed,
    @Column("important") boolean important,
    @Column("created_at") LocalDateTime createdAt
) {
  public TaskEntity(Long id, String title, String description, boolean completed, boolean important,
                    LocalDateTime createdAt) {
    this.id = id;
    this.title = title;
    this.description = description == null ? "" : description;
    this.completed = completed;
    this.important = important;
    this.createdAt = createdAt;
  }

  public TaskEntity(String title, String description, boolean completed, boolean important,
                    LocalDateTime createdAt) {
    this(null, title, description, completed, important, createdAt);
  }
}

package hu.aestallon.agenda.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableJdbcRepositories
public class AppAgendaApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppAgendaApplication.class, args);
  }

}

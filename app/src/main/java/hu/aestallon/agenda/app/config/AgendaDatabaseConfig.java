package hu.aestallon.agenda.app.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@Profile("h2")
@EnableConfigurationProperties(AgendaDatabaseConfig.DatasourceSettings.class)
public class AgendaDatabaseConfig extends AbstractJdbcConfiguration {

  @Bean
  @Profile("h2")
  @Qualifier("dataSourceH2")
  DataSource dataSource(DatasourceSettings settings) {
    DatasourceSetting h2 = settings.getSettings().get("h2");
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl(h2.getDbaseUrl());
    dataSource.setUsername(h2.getUsername());
    dataSource.setPassword(h2.getPassword());
    return dataSource;
  }

  @Bean
  @Profile("h2 & bootstrap")
  @Qualifier("dataSourceInitializerH2")
  DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
    DataSourceInitializer initializer = new DataSourceInitializer();
    initializer.setDataSource(dataSource);

    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(new ClassPathResource("/script/init-h2.sql"));
    initializer.setDatabasePopulator(populator);

    return initializer;
  }

  @Bean
  @Profile("h2")
  @Qualifier("namedParameterJdbcOperationsH2")
  NamedParameterJdbcOperations namedParameterJdbcOperations(
      @Qualifier("dataSourceH2") DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
  }

  @Bean
  @Profile("h2")
  @Qualifier("transactionManagerH2")
  TransactionManager transactionManager(@Qualifier("dataSourceH2") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @NoArgsConstructor
  @Data
  @ConfigurationProperties(prefix = "agenda-db")
  public static class DatasourceSettings {
    Map<String, DatasourceSetting> settings;
  }

  @NoArgsConstructor
  @Data
  public static class DatasourceSetting {
    String username;
    String password;
    String dbaseUrl;
  }

}

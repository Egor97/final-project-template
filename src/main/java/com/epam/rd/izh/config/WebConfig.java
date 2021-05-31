package com.epam.rd.izh.config;

import com.epam.rd.izh.dto.UserDTO;
import com.epam.rd.izh.repository.UserRepository;
import com.epam.rd.izh.service.UnknownUserService;
import com.epam.rd.izh.util.PersonRowMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class WebConfig {
  /**
   * Данный класс можно использовать для создание бинов приложения, например бин ObjectMapper для десериализации.
   * Этот класс не является обязательным, но является стандартным там, где используется настройка бинов.
   */
  PasswordEncoder passwordEncoder;
  UserRepository userRepository;

  @Value("${spring.database.driverClassName}")
  private String className;
  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String name;

  @Bean
  public UnknownUserService unknownUserService() {
      return new UnknownUserService(userRepository);
  }

  @Bean
//  @Scope("prototype")
  public UserDTO userDTO() {
    return new UserDTO(passwordEncoder);
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public DataSource dataSource() {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName(className);
    dataSourceBuilder.url(url);
    dataSourceBuilder.username(name);
    dataSourceBuilder.password("asgardThror223");
    return dataSourceBuilder.build();
  }

  @Bean
  public PersonRowMapper personRowMapper() {
    return new PersonRowMapper();
  }
}

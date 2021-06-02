package com.epam.rd.izh.config;

import com.epam.rd.izh.dto.UserDTO;
import com.epam.rd.izh.repository.BookRepositoryImpl;
import com.epam.rd.izh.repository.UserRepository;
import com.epam.rd.izh.service.AuthorizedUserService;
import com.epam.rd.izh.service.UnknownUserService;
import com.epam.rd.izh.util.PersonRowMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@PropertySource("classpath:application.properties")
public class WebConfig {
  /**
   * Данный класс можно использовать для создание бинов приложения, например бин ObjectMapper для десериализации.
   * Этот класс не является обязательным, но является стандартным там, где используется настройка бинов.
   */
  UserRepository userRepository;

  @Value("${spring.database.driverClassName}")
  private String className;
  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String name;
  @Value("${spring.datasource.password}")
  private String pass;

  @Bean
  public UnknownUserService unknownUserService() {
      return new UnknownUserService(userRepository);
  }

  @Bean
  public UserDTO userDTO() {
    return new UserDTO();
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(className);
    dataSource.setUrl(url);
    dataSource.setUsername(name);
    dataSource.setPassword(pass);
    dataSource.setDefaultAutoCommit(false);
    return dataSource;
  }

  @Bean
  public PersonRowMapper personRowMapper() {
    return new PersonRowMapper();
  }

  @Bean
  public AuthorizedUserService authorizedUserService() {
    return new AuthorizedUserService(userRepository);
  }

  @Bean
  public BookRepositoryImpl bookRepository() {
    return new BookRepositoryImpl(new ArrayList<>(), jdbcTemplate());
  }
}

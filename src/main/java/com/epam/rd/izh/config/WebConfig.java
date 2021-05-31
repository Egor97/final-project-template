package com.epam.rd.izh.config;

import com.epam.rd.izh.dto.UserDTO;
import com.epam.rd.izh.repository.UserRepository;
import com.epam.rd.izh.service.UnknownUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
  DataSource datasource;
  PasswordEncoder passwordEncoder;
  UserRepository userRepository;

  @Bean
  public UnknownUserService unknownUserService() {
      return new UnknownUserService(userRepository);
  }

  @Bean
  public UserDTO userDTO() {
    return new UserDTO(passwordEncoder);
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(datasource);
  }


//  public DataSource dataSource() {
//    @Value("${spring.database.driverClassName}")
//    String className;
//    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//    dataSourceBuilder.driverClassName(className);
//    return dataSourceBuilder.build();
//  }
}

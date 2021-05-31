package com.epam.rd.izh.repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.epam.rd.izh.dto.UserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.UnknownUser;
import com.epam.rd.izh.util.MappingUtilsForUserDTO;
import com.epam.rd.izh.util.PersonRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Данный репозиторий хранит список зарегистрированных пользователей;
 * На данный момент он представляет из себя коллекцию List<AuthorizedUser> и методы доступа к ней;
 *
 * Необходимо превратить данный репозиторий в DAO класс:
 * Создать базу данных, подключить ее к приложению, сделать CRUD операции (или их часть) для доступа
 * к хранящимся сущностям.
 * Создать другие DAO классы для хранения бизнес-сущностей выбранной темы финального проекта в этом же пакете.
 */

@Repository
public class UserRepository {

  JdbcTemplate jdbcTemplate;
  MappingUtilsForUserDTO mappingUtilsForUserDTO;
  PersonRowMapper personRowMapper;

  public UserRepository(JdbcTemplate jdbcTemplate, MappingUtilsForUserDTO mappingUtilsForUserDTO,
                        PersonRowMapper personRowMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.mappingUtilsForUserDTO = mappingUtilsForUserDTO;
    this.personRowMapper = personRowMapper;
  }

  //  create UserDTO
  public boolean createNewUser(@Nullable UnknownUser unknownUser) {
    if (unknownUser != null) {
      UserDTO userDTO = mappingUtilsForUserDTO.mapToUserDTO(unknownUser);
      jdbcTemplate.update("insert into person (login, password, fname, lname, email, role) values(?, ?, ?, ?, ?, ?)",
              userDTO.getLogin(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(),
              userDTO.getEmail(), userDTO.getRole());
      return true;
    }

    return false;
  }
  /**
   * В данном методе использована библиотека Stream API:
   * .filter проверяет каждый элемент коллекции на удовлетворение условия .equals(login), в случае, если совпадающий
   * элемент будет найдет, он будет возвращен методом .findFirst(). Если в коллекции не будет найдет удовлетворяющий
   * условию элемент, методом .orElse(null) будет возвращен null.
   * Допускается использовать вместо  Stream API стандартные циклы For и While.
   *
   * аннотации @Nullable и @Nonnull расставляются над возвращающими не примитивные значения методами и передаваемыми
   * в метод аргументами.
   */

  //  get UserDTO
  @Nullable
  public AuthorizedUser getAuthorizedUserByLogin(@Nonnull String login) {
    UserDTO userDTO = jdbcTemplate.queryForObject(
            "select * from person where login = ?",
            new Object[]{login}, personRowMapper
            );

    return (userDTO != null) ? mappingUtilsForUserDTO.mapToAuthorizedUser(userDTO) : null;
  }

}

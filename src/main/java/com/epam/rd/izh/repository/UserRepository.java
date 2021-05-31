package com.epam.rd.izh.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.epam.rd.izh.dto.UserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.UnknownUser;
import com.epam.rd.izh.util.MappingUtilsForUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
  private final List<UserDTO> users = new ArrayList<>();

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  MappingUtilsForUserDTO mappingUtilsForUserDTO;

  public UserRepository(MappingUtilsForUserDTO mappingUtilsForUserDTO) {
    this.mappingUtilsForUserDTO = mappingUtilsForUserDTO;
  }

  public UserDTO getUserByLogin(String login) {
    return users.stream().filter(userDTO -> userDTO.getLogin().contains(login)).findFirst().orElse(null);
  }

  public boolean createNewUser(@Nullable UnknownUser unknownUser) {
    if (unknownUser != null) {
      UserDTO userDTO = mappingUtilsForUserDTO.mapToUserDTO(unknownUser);
      jdbcTemplate.update("insert into person (login, password, fname, lname, email, role) values(?, ?, ?, ?, ?, ?)",
              userDTO.getLogin(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(),
                      userDTO.getEmail(), userDTO.getRole());
      return users.add(userDTO);
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

  @Nullable
  public AuthorizedUser getAuthorizedUserByLogin(@Nonnull String login) {
    UserDTO userDTO = users.stream()
        .filter(value -> value.getLogin().equals(login))
        .findFirst().orElse(null);
    return userDTO != null ? mappingUtilsForUserDTO.mapToAuthorizedUser(userDTO) : null;
  }

//  public boolean addAuthorizedUser(@Nullable UnknownUser user) {
//    if (user != null) {
//      users.add(mappingUtilsForUserDTO.mapToUserDTO(user));
//      return true;
//    }
//    return false;
//  }

}

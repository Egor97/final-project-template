package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.UnknownUser;
import com.epam.rd.izh.repository.UserRepository;
import javax.validation.Valid;

import com.epam.rd.izh.service.UnknownUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * В аргументы контроллеров, которые обрабатывают запросы, можно указать дополнительные входные параметры: Например:
 * HttpServletRequest и HttpServletResponse. Данные объекты автоматически заполняться данными о реквесте и респонсе. Эти
 * данные можно использовать, например достать куки, сессию, хедеры итд.
 */

@Controller
public class AuthenticationController {

  @Autowired
  UnknownUserService unknownUserService;

  /**
   * Метод, отвечающий за логику авторизации пользователя.
   * /login - определяет URL, по которому пользователь должен перейти, чтобы запустить данный метод-обработчик.
   */
  @GetMapping("/login")
  public String login(Model model, @RequestParam(required = false) String error) {
    if (error != null) {
      /**
       * Model представляет из себя Map коллекцию ключ-значения, распознаваемую View элементами MVC.
       * Добавляется String "invalid login or password!", с ключем "error_login_placeholder".
       * При создании View шаблона плейсхолдер ${error_login_placeholder} будет заменен на переданное значение.
       *
       * В класс Model можно передавать любые объекты, необходимые для генерации View.
       */
      model.addAttribute("error_login_placeholder", "invalid login or password!");
    }
    /**
     * Контроллер возвращает String название JSP страницы.
     * В application.properties есть следующие строки:
     * spring.mvc.view.prefix=/WEB-INF/pages/
     * spring.mvc.view.suffix=.jsp
     * Spring MVC, используя суффикс и префикс, создаст итоговый путь к JSP: /WEB-INF/pages/login.html
     */
    return "login";
  }

  /**
   * Метод, отвечающий за логику регистрации пользователя.
   */
  @GetMapping("/registration")
  public String viewRegistration(Model model) {
    if(!model.containsAttribute("registrationForm")){
      model.addAttribute("registrationForm", new UnknownUser());
    }
    return "registration";
  }

  /**
   * Метод, отвечающий за подтверждение регистрации пользователя и сохранение данных в репозиторий или DAO.
   */
  @PostMapping("/registration/proceed")
  public String processRegistration(@Valid @ModelAttribute("registrationForm") UnknownUser unknownUser,
      BindingResult bindingResult, RedirectAttributes redirectAttributes) {

    /**
     * Здесь по желанию можно добавить валидацию введенных данных на back-end слое.
     * Для этого необходимо написать реализацию Validator.
     */
    //registeredUser.validate(registeredUserDto, bindingResult);

    if (bindingResult.hasErrors()) {
      //логика отображения ошибки, не является обязательной
      //...
      //...
      return "redirect:/registration";
    }
    /**
     * Здесь происходит присвоение роли пользователю и шифрование пароля.
     * Роль может быть так же определена пользователем на этапе регистрации, либо иным способов, зависящим
     * от темы финального проекта.
     * registeredUser может быть DTO объектом, преобразуемым в AuthorizedUser сущность в сервисе-маппере
     * (эот сервис нужно написать самим), вместе с присвоением роли и шифрованием пароля.
     */

    System.out.println(unknownUser.toString());
    return (unknownUserService.addNewRegisteredUser(unknownUser)) ? "redirect:/login" : "registration";

    /**
     * Добавление пользователя в репозиторий или в базу данных через CRUD операции DAO.
     * Рекомендуется вынести эту логику на сервисный слой.
     */

    /**
     * В случае успешной регистрации редирект можно настроить на другой энд пойнт.
     */
  }

}
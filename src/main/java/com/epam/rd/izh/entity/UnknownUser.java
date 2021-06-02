package com.epam.rd.izh.entity;

import lombok.Data;

import javax.validation.constraints.*;

//import java.util.Calendar;

@Data
public class UnknownUser {

    @Size(min = 2, max = 30)
    @NotNull
    private String login;

    @Size(min = 8, message = "Пароль слишком короткий")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
            message = "Пароль должен содержать 1 заглавную букву, 1 цифру, 1 специальный символ")
    @NotNull
    private String password;

    @NotBlank(message = "Имя не должно быть пустым, представьтесь!")
    private String firstName;

    @NotNull(message = "Фамилия не может отсутствовать, представьтесь!")
    private String lastName;
//    private Calendar dob;
    @Email(message = "ошибка формата электронной почты")
    @NotNull
    private String email;

    @Null
    private String role;
}

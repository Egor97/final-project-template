package com.epam.rd.izh.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class Book {

    @NotNull
    private long id;

    @Max(200)
    @NotNull
    private String title;

    @Length(min = 2, max = 200)
    @NotNull
    private String author;

    @Length(max=1000)
    private String summary;

    @Length(max=13)
    @NotNull
    private String isbn;

    @NotBlank(message = "Укажите Жанр произведения")
    private String genre;

    @Size(max=200)
    @NotBlank
    private String language;
}

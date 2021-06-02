package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Book;

import java.util.ArrayList;

public interface BookRepository<T> {

    ArrayList<T> getAllBooks();

    Book getBookById();

    boolean createBook();

    boolean deleteBook();
}

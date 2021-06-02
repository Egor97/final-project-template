package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookRepositoryImpl extends AbstractBookRepository<Book> implements BookRepository<Book> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public BookRepositoryImpl(ArrayList<Book> arrayList, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.holder = arrayList;
    }

    @Override
    void setHolder() {
        this.holder = new ArrayList<>();
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookById() {
        return null;
    }

    @Override
    public boolean createBook() {
        return false;
    }

    @Override
    public boolean deleteBook() {
        return false;
    }
}

package com.epam.rd.izh.repository;

import java.util.List;

public abstract class AbstractBookRepository<T> {

    protected List<T> holder;

    abstract void setHolder();
}

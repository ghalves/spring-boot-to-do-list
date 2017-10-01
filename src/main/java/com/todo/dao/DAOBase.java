package com.todo.dao;

import java.util.Collection;

public interface DAOBase<T> {
    void create(T t);

    void update(T t);

    T delete(int id);

    T findById(int id);

    Collection<T> list();
}

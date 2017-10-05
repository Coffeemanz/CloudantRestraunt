package com.iba.dao.dao.interfaces;

import java.util.List;

public interface BaseDao<T> {

    String save(T model);

    List<T> getAll();

    T getById(String id);

    Boolean update(T model);

    Boolean delete(String id);

}

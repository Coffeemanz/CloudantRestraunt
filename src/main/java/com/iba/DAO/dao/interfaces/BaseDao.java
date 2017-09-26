package com.iba.DAO.dao.interfaces;

import com.cloudant.client.api.views.AllDocsRequestBuilder;

import java.util.List;

public interface BaseDao<T> {

    Boolean save(T model);

    List<T> getAll();

    T getById(String id);

    Boolean update(T model);

    Boolean delete(T model);

}

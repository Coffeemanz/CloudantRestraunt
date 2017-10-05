package com.iba.services.interfaces;

import com.iba.models.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel> {

    String save(T model);

    void delete(String id);

    void update(T model);

    List<T> getAll();

    T getbyId(String id);
}

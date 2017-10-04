package com.iba.Services.interfaces;

import com.iba.Models.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel> {

    String save(T model);

    void delete(String id);

    void update(T model);

    List<T> getAll();

    T getbyId(String id);
}

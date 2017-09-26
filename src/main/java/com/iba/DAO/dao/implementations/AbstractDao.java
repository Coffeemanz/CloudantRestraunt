package com.iba.DAO.dao.implementations;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.views.AllDocsRequestBuilder;
import com.iba.DAO.dao.interfaces.BaseDao;
import com.iba.DAO.dao.service_classes.CloudantConfiguration;
import com.iba.Models.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.util.List;

public abstract class AbstractDao<T extends BaseModel> implements BaseDao<T> {


    @Autowired
    protected CloudantConfiguration client;

    private Class<T> persistentClass;

    protected Database database;

    public AbstractDao(Database database, Class<T> persistentClass)
    {
        this.database = database;
        this.persistentClass = persistentClass;
    }


    @Override
    public Boolean save(T model) {
        return (database.save(model).getError() == null);
    }

    @Override
    public List<T> getAll()
    {
        List<T>  allDocs = null;
        try {
            allDocs = database.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(persistentClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allDocs;

    }

    @Override
    public T getById(String id)
    {
        return database.find(persistentClass, id);
    }


    @Override
    public Boolean update(T model)
    {
        return (database.update(model).getError() == null);
    }

    @Override
    public Boolean delete(T model)
    {
        return (database.remove(model).getError() == null);
    }
}

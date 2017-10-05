package com.iba.dao.dao.implementations;

import com.cloudant.client.api.Database;
import com.cloudant.client.org.lightcouch.CouchDbException;
import com.iba.dao.dao.interfaces.BaseDao;
import com.iba.dao.dao.service_classes.CloudantConfiguration;
import com.iba.dao.exceptions.DaoException;
import com.iba.models.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public abstract class AbstractDao<T extends BaseModel> implements BaseDao<T> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);

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
    public String save(T model)
    {
        String id  = null;
        try {
            id = database.save(model).getId();
            logger.debug("The model: "  + id + " successfully saved");
        } catch (CouchDbException e) {
            logger.error("Error was thrown in AbstractDao method save: " + e);
            throw new DaoException(e);
        }
        return id;
    }

    @Override
    public List<T> getAll()
    {
        List<T>  allDocs = null;
        try {
            allDocs = database.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(persistentClass);
            logger.debug("All models successfully found!");
        } catch (IOException e) {
            logger.error("Error was thrown in AbstractDao method update: " + e);
            throw new DaoException(e);
        }
        return allDocs;

    }

    @Override
    public T getById(String id)
    {
        T model = null;
        try {
            model = database.find(persistentClass, id);
            logger.debug("The model: "  + id + " successfully found");
        } catch (CouchDbException e) {
            logger.error("Error was thrown in AbstractDao method getById: " + e);
            throw new DaoException(e);
        }
        return model;
    }


    @Override
    public Boolean update(T model)
    {
        Boolean updated = null;
        try {
            updated = database.update(model).getError() == null;
            logger.debug("The model: "  + model.get_id() + " successfully updated");
        } catch (CouchDbException e) {
            logger.error("Error was thrown in AbstractDao method update: " + e);
            throw new DaoException(e);
        }
        return updated;
    }

    @Override
    public Boolean delete(String id)
    {
        Boolean deleted = null;
        try {
            T model = getById(id);
            deleted = database.remove(model).getError() == null;
            logger.debug("The model: "  + id + " successfully deleted");
        } catch (CouchDbException e) {
            logger.error("Error was thrown in AbstractDao method delete: " + e);
            throw new DaoException(e);
        }
        return deleted;
    }
}

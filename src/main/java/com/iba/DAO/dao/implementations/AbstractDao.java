package com.iba.DAO.dao.implementations;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.views.AllDocsRequestBuilder;
import com.iba.DAO.dao.interfaces.BaseDao;
import com.iba.DAO.dao.service_classes.CloudantConfiguration;
import com.iba.Models.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
        String id  = database.save(model).getId();
        logger.debug("The model: "  + id + " successfully saved");
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
            e.printStackTrace();
        }
        return allDocs;

    }

    @Override
    public T getById(String id)
    {
        T model = database.find(persistentClass, id);
        logger.debug("The model: "  + id + " successfully found");
        return model;
    }


    @Override
    public Boolean update(T model)
    {
        Boolean updated = database.update(model).getError() == null;
        logger.debug("The model: "  + model.get_id() + " successfully updated");
        return updated;
    }

    @Override
    public Boolean delete(String id)
    {
        T model = getById(id);
        Boolean deleted = database.remove(model).getError() == null;
        logger.debug("The model: "  + id + " successfully deleted");
        return deleted;
    }
}

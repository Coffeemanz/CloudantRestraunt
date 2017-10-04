package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.FoodDaoImpl;
import com.iba.DAO.exceptions.DaoException;
import com.iba.Models.FoodModel;
import com.iba.Services.exceptions.ServiceException;
import com.iba.Services.interfaces.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private static final Logger logger = LoggerFactory.getLogger(FoodServiceImpl.class);

    @Autowired
    private FoodDaoImpl foodDao;

    @Override
    public String save(FoodModel model) {
        String id = null;
        try {
            id = foodDao.save(model);
            logger.debug("Food " + id + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in FoodService method save: " + e);
            throw new ServiceException(e);
        }
        return id;
    }

    @Override
    public void delete(String id) {
        try {
            foodDao.delete(id);
            logger.debug("Food " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in FoodService method delete: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(FoodModel model) {
        try {
            foodDao.update(model);
            logger.debug("Food " + model.get_id() + " successfully updated");
        } catch (DaoException e) {
            logger.error("Error was thrown in FoodService method update: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<FoodModel> getAll() {
        List<FoodModel> allModels = null;
        try {
            allModels = foodDao.getAll();
            logger.debug("All food successfully found!");
        } catch (DaoException e) {
            logger.error("Error was thrown in FoodService method getAll: " + e);
            throw new ServiceException(e);
        }
        return allModels;
    }

    @Override
    public FoodModel getbyId(String id) {
        FoodModel foodModel = null;
        try {
            foodModel = foodDao.getById(id);
            logger.debug("Food " + id + " successfully found");
        } catch (DaoException e) {
            logger.error("Error was thrown in FoodService method getById: " + e);
            throw new ServiceException(e);
        }
        return foodModel;
    }
}

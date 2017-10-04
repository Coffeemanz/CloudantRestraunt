package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.FoodDaoImpl;
import com.iba.Models.FoodModel;
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
        String id = foodDao.save(model);
        logger.debug("Food " + id + " successfully saved!");
        return id;
    }

    @Override
    public void delete(String id) {
        foodDao.delete(id);
        logger.debug("Food " + id + " successfully deleted!");
    }

    @Override
    public void update(FoodModel model) {
        foodDao.update(model);
        logger.debug("Food " + model.get_id() + " successfully updated");
    }

    @Override
    public List<FoodModel> getAll() {
        List<FoodModel> allModels = foodDao.getAll();
        logger.debug("All food successfully found!");
        return allModels;
    }

    @Override
    public FoodModel getbyId(String id) {
        FoodModel foodModel = foodDao.getById(id);
        logger.debug("Food " + id + " successfully found");
        return foodModel;
    }
}

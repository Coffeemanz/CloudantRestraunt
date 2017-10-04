package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.FoodDaoImpl;
import com.iba.Models.FoodModel;
import com.iba.Services.interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDaoImpl foodDao;

    @Override
    public String save(FoodModel model) {
        return foodDao.save(model);
    }

    @Override
    public void delete(String id) {
        foodDao.delete(id);
    }

    @Override
    public void update(FoodModel model) {
        foodDao.update(model);
    }

    @Override
    public List<FoodModel> getAll() {
        List<FoodModel> allModels = foodDao.getAll();
        return allModels;
    }

    @Override
    public FoodModel getbyId(String id) {
        FoodModel foodModel = foodDao.getById(id);
        return foodModel;
    }
}

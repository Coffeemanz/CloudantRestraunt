package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.WaiterDaoImpl;
import com.iba.Models.WaiterModel;
import com.iba.Services.interfaces.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterServiceImpl implements WaiterService {

    @Autowired
    private WaiterDaoImpl waiterDao;

    @Override
    public String save(WaiterModel model) {
        return waiterDao.save(model);
    }

    @Override
    public void delete(String id) {
        waiterDao.delete(id);
    }

    @Override
    public void update(WaiterModel model) {
        waiterDao.update(model);
    }

    @Override
    public List<WaiterModel> getAll() {
        List<WaiterModel> allModels = waiterDao.getAll();
        return allModels;
    }

    @Override
    public WaiterModel getbyId(String id) {
        WaiterModel waiterModel = waiterDao.getById(id);
        return waiterModel;
    }
}

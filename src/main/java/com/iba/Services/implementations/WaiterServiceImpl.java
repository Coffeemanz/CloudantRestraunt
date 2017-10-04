package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.WaiterDaoImpl;
import com.iba.Models.WaiterModel;
import com.iba.Services.interfaces.WaiterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterServiceImpl implements WaiterService {

    private static final Logger logger = LoggerFactory.getLogger(WaiterServiceImpl.class);

    @Autowired
    private WaiterDaoImpl waiterDao;

    @Override
    public String save(WaiterModel model) {
        String id = waiterDao.save(model);
        logger.debug("Waiter " + id + " successfully saved!");
        return waiterDao.save(model);
    }

    @Override
    public void delete(String id) {
        waiterDao.delete(id);
        logger.debug("Waiter " + id + " successfully deleted!");
    }

    @Override
    public void update(WaiterModel model) {
        waiterDao.update(model);
        logger.debug("Waiter " + model.get_id() + " successfully updated");
    }

    @Override
    public List<WaiterModel> getAll() {
        List<WaiterModel> allModels = waiterDao.getAll();
        logger.debug("All waiters successfully found!");
        return allModels;
    }

    @Override
    public WaiterModel getbyId(String id) {
        WaiterModel waiterModel = waiterDao.getById(id);
        logger.debug("Waiter " + id + " successfully found");
        return waiterModel;
    }
}

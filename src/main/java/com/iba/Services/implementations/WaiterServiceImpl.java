package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.WaiterDaoImpl;
import com.iba.DAO.exceptions.DaoException;
import com.iba.Models.WaiterModel;
import com.iba.Services.exceptions.ServiceException;
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
        String id = null;
        try {
            id = waiterDao.save(model);
            logger.debug("Waiter " + id + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in WaiterService method save: " + e);
            throw new ServiceException(e);
        }
        return id;
    }

    @Override
    public void delete(String id) {
        try {
            waiterDao.delete(id);
            logger.debug("Waiter " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in WaiterService method delete: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(WaiterModel model) {
        try {
            waiterDao.update(model);
            logger.debug("Waiter " + model.get_id() + " successfully updated");
        } catch (DaoException e) {
            logger.error("Error was thrown in WaiterService method update: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<WaiterModel> getAll() {
        List<WaiterModel> allModels = null;
        try {
            allModels = waiterDao.getAll();
            logger.debug("All waiters successfully found!");
        } catch (DaoException e) {
            logger.error("Error was thrown in WaiterService method getAll: " + e);
            throw new ServiceException(e);
        }
        return allModels;
    }

    @Override
    public WaiterModel getbyId(String id) {
        WaiterModel waiterModel = null;
        try {
            waiterModel = waiterDao.getById(id);
            logger.debug("Waiter " + id + " successfully found");
        } catch (DaoException e) {
            logger.error("Error was thrown in WaiterService method getById: " + e);
            throw new ServiceException(e);
        }
        return waiterModel;
    }
}

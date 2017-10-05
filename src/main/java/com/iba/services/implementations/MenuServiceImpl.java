package com.iba.services.implementations;

import com.iba.dao.dao.implementations.MenuDaoImpl;
import com.iba.dao.exceptions.DaoException;
import com.iba.models.MenuModel;
import com.iba.services.exceptions.ServiceException;
import com.iba.services.interfaces.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuDaoImpl menuDao;

    @Override
    public String save(MenuModel model) {

        String id = null;
        try {
            id = menuDao.save(model);
            logger.debug("Menu " + id + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in MenuService method save: " + e);
            throw new ServiceException(e);
        }
        return id;
    }

    @Override
    public void delete(String id) {
        try {
            menuDao.delete(id);
            logger.debug("Menu " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in MenuService method delete: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(MenuModel model) {

        try {
            menuDao.update(model);
            logger.debug("Menu " + model.get_id() + " successfully updated");
        } catch (DaoException e) {
            logger.error("Error was thrown in MenuService method update: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<MenuModel> getAll() {
        List<MenuModel> allModels = null;
        try {
            allModels = menuDao.getAll();
            logger.debug("All menu successfully found!");
        } catch (DaoException e) {
            logger.error("Error was thrown in MenuService method getAll: " + e);
            throw new ServiceException(e);
        }
        return allModels;
    }

    @Override
    public MenuModel getbyId(String id) {
        MenuModel menuModel = null;
        try {
            menuModel = menuDao.getById(id);
            logger.debug("Menu " + id + " successfully found");
        } catch (DaoException e) {
            logger.error("Error was thrown in MenuService method getById: " + e);
            throw new ServiceException(e);
        }
        return menuModel;
    }
}

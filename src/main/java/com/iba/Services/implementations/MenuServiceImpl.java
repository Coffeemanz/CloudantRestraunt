package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.MenuDaoImpl;
import com.iba.Models.MenuModel;
import com.iba.Services.interfaces.MenuService;
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

        String id = menuDao.save(model);
        logger.debug("Menu " + id + " successfully saved!");
        return id;
    }

    @Override
    public void delete(String id) {
        menuDao.delete(id);
        logger.debug("Menu " + id + " successfully deleted!");
    }

    @Override
    public void update(MenuModel model) {

        menuDao.update(model);
        logger.debug("Menu " + model.get_id() + " successfully updated");
    }

    @Override
    public List<MenuModel> getAll() {
        List<MenuModel> allModels = menuDao.getAll();
        logger.debug("All menu successfully found!");
        return allModels;
    }

    @Override
    public MenuModel getbyId(String id) {
        MenuModel menuModel = menuDao.getById(id);
        logger.debug("Menu " + id + " successfully found");
        return menuModel;
    }
}

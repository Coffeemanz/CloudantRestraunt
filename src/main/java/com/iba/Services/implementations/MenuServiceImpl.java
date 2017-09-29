package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.MenuDaoImpl;
import com.iba.Models.MenuModel;
import com.iba.Services.interfaces.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDaoImpl menuDao;

    @Override
    public String save(MenuModel model) {
        return menuDao.save(model);
    }

    @Override
    public void delete(MenuModel model) {
        menuDao.delete(model);
    }

    @Override
    public void update(MenuModel model) {
        menuDao.update(model);
    }

    @Override
    public List<MenuModel> getAll() {
        List<MenuModel> allModels = menuDao.getAll();
        return allModels;
    }

    @Override
    public MenuModel getbyId(String id) {
        MenuModel menuModel = menuDao.getById(id);
        return menuModel;
    }
}

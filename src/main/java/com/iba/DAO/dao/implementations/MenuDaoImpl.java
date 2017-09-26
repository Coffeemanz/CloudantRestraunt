package com.iba.DAO.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.DAO.dao.interfaces.BaseDao;
import com.iba.Models.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl extends AbstractDao<MenuModel> implements BaseDao<MenuModel> {

    public MenuDaoImpl(@Autowired
                       @Qualifier("menuDatabase")
                               Database MenuDb)
    {
        super(MenuDb, MenuModel.class);
    }

}

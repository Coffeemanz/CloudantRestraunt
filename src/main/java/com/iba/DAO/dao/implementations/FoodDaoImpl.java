package com.iba.DAO.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.DAO.dao.interfaces.BaseDao;
import com.iba.Models.FoodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDaoImpl extends AbstractDao<FoodModel> implements BaseDao<FoodModel> {

    public FoodDaoImpl(@Autowired
                       @Qualifier("foodDatabase")
                               Database FoodDb)
    {
        super(FoodDb, FoodModel.class);
    }

}

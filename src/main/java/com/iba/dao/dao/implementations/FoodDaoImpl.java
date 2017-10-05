package com.iba.dao.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.dao.dao.interfaces.BaseDao;
import com.iba.models.FoodModel;
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

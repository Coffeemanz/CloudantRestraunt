package com.iba.dao.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.dao.dao.interfaces.BaseDao;
import com.iba.models.WaiterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WaiterDaoImpl extends AbstractDao<WaiterModel> implements BaseDao<WaiterModel> {

    public WaiterDaoImpl(@Autowired
                       @Qualifier("waiterDatabase")
                               Database WaiterDb)
    {
        super(WaiterDb, WaiterModel.class);
    }

}

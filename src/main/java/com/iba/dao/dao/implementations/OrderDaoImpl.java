package com.iba.dao.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.dao.dao.interfaces.BaseDao;
import com.iba.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractDao<OrderModel> implements BaseDao<OrderModel> {

    public OrderDaoImpl(@Autowired
                       @Qualifier("orderDatabase")
                               Database OrderDb)
    {
        super(OrderDb, OrderModel.class);
    }

}

package com.iba.DAO.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.DAO.dao.interfaces.BaseDao;
import com.iba.Models.OrderModel;
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

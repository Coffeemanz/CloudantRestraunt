package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.OrderDaoImpl;
import com.iba.Models.OrderModel;
import com.iba.Services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDaoImpl orderDao;

    @Override
    public String save(OrderModel model) {
        return orderDao.save(model);
    }

    @Override
    public void delete(String id) {
        orderDao.delete(id);
    }

    @Override
    public void update(OrderModel model) {
        orderDao.update(model);
    }

    @Override
    public List<OrderModel> getAll() {
        List<OrderModel> allModels = orderDao.getAll();
        return allModels;
    }

    @Override
    public OrderModel getbyId(String id) {
        OrderModel orderModel = orderDao.getById(id);
        return orderModel;
    }
}

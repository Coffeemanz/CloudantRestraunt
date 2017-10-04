package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.OrderDaoImpl;
import com.iba.Models.OrderModel;
import com.iba.Services.interfaces.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDaoImpl orderDao;

    @Override
    public String save(OrderModel model) {
        String id = orderDao.save(model);
        logger.debug("Order " + id + " successfully saved!");
        return id;
    }

    @Override
    public void delete(String id) {
        orderDao.delete(id);
        logger.debug("Order " + id + " successfully deleted!");
    }

    @Override
    public void update(OrderModel model) {
        orderDao.update(model);
        logger.debug("Order " + model.get_id() + " successfully updated");
    }

    @Override
    public List<OrderModel> getAll() {
        List<OrderModel> allModels = orderDao.getAll();
        logger.debug("All order successfully found!");
        return allModels;
    }

    @Override
    public OrderModel getbyId(String id) {
        OrderModel orderModel = orderDao.getById(id);
        logger.debug("Order " + id + " successfully found");
        return orderModel;
    }
}

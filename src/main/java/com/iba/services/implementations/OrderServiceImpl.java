package com.iba.services.implementations;

import com.iba.dao.dao.implementations.OrderDaoImpl;
import com.iba.dao.exceptions.DaoException;
import com.iba.models.OrderModel;
import com.iba.services.exceptions.ServiceException;
import com.iba.services.interfaces.OrderService;
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
        String id = null;
        try {
            id = orderDao.save(model);
            logger.debug("Order " + id + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in OrderService method save: " + e);
            throw new ServiceException(e);
        }
        return id;
    }

    @Override
    public void delete(String id) {
        try {
            orderDao.delete(id);
            logger.debug("Order " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in OrderService method delete: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(OrderModel model) {
        try {
            orderDao.update(model);
            logger.debug("Order " + model.get_id() + " successfully updated");
        } catch (DaoException e) {
            logger.error("Error was thrown in OrderService method update: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderModel> getAll() {
        List<OrderModel> allModels = null;
        try {
            allModels = orderDao.getAll();
            logger.debug("All order successfully found!");
        } catch (DaoException e) {
            logger.error("Error was thrown in OrderService method getAll: " + e);
            throw new ServiceException(e);
        }
        return allModels;
    }

    @Override
    public OrderModel getbyId(String id) {
        OrderModel orderModel = null;
        try {
            orderModel = orderDao.getById(id);
            logger.debug("Order " + id + " successfully found");
        } catch (DaoException e) {
            logger.error("Error was thrown in OrderService method getById: " + e);
            throw new ServiceException(e);
        }
        return orderModel;
    }
}

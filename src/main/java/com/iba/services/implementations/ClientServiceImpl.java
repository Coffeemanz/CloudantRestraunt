package com.iba.services.implementations;

import com.iba.dao.dao.implementations.ClientDaoImpl;
import com.iba.dao.exceptions.DaoException;
import com.iba.models.ClientModel;
import com.iba.models.FoodModel;
import com.iba.models.OrderModel;
import com.iba.services.exceptions.NotEnoughMoneyException;
import com.iba.services.exceptions.ServiceException;
import com.iba.services.interfaces.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientDaoImpl clientDao;

    @Autowired
    private FoodServiceImpl foodService;

    @Autowired
    private OrderServiceImpl orderService;

    @Override
    public String save(ClientModel model) {
        String id = null;
        try {
            id = clientDao.save(model);
            logger.debug("Client " + id + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in ClientService method save: " + e);
            throw new ServiceException(e);
        }
        return id;
    }

    @Override
    public void delete(String id) {
        try {
            clientDao.delete(id);
            logger.debug("Client " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in ClientService method delete: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(ClientModel model) {
        try {
            clientDao.update(model);
            logger.debug("Client " + model.get_id() + " successfully updated");
        } catch (DaoException e) {
            logger.error("Error was thrown in ClientService method update: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ClientModel> getAll() {
        List<ClientModel> allModels = null;
        try {
            allModels = clientDao.getAll();
            logger.debug("All clients successfully found!");
        } catch (DaoException e) {
            logger.error("Error was thrown in ClientService method getAll: " + e);
            throw new ServiceException(e);
        }
        return allModels;
    }

    @Override
    public ClientModel getbyId(String id) {
        ClientModel clientModel = null;
        try {
            clientModel = clientDao.getById(id);
            logger.debug("Client " + id + " successfully found");
        } catch (DaoException e) {
            logger.error("Error was thrown in ClientService method getById: " + e);
            throw new ServiceException(e);
        }
        return clientModel;
    }

    public String getFood(String clientId, String foodId)
    {
        ClientModel clientModel = getbyId(clientId);
        FoodModel foodModel = foodService.getbyId(foodId);
        String orderId = null;

        List<OrderModel> orderModels = orderService.getAll();
        OrderModel orderModel = null;

        for (OrderModel orderModel1: orderModels)
        {
            if ((orderModel1.getClient_id() != null) && (orderModel1.getClient_id().equals(clientId)))
            {
                orderModel = orderModel1;
                break;
            }
            else orderModel = new OrderModel();
        }

        ArrayList<String> foodModelsIDS;
        if (orderModel.getFood_idS() != null) foodModelsIDS = orderModel.getFood_idS();
        else foodModelsIDS = new ArrayList<>();


        try
        {
            if (clientModel.getClient_cash() < foodModel.getFoood_price())
            {
                throw new NotEnoughMoneyException("Not enough money!");
            }
            else
            {
                clientModel.setClient_cash(clientModel.getClient_cash() - foodModel.getFoood_price());
                update(clientModel);
            }
            foodModelsIDS.add(foodModel.get_id());
            orderModel.setFood_idS(foodModelsIDS);
            orderModel.setClient_id(clientId);
            orderId = orderModel.get_id();

            if (orderModels.contains(orderModel))
            {
                orderService.update(orderModel);
            }
            else
                {
                    orderService.save(orderModel);
                }
        }
        catch (DaoException e)
        {
            logger.error("Error in getFood method in ClientServiceImpl: " + e);
            throw new ServiceException(e);
        }
        return orderId;
    }
}

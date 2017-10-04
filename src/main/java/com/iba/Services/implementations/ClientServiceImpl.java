package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.ClientDaoImpl;
import com.iba.DAO.exceptions.DaoException;
import com.iba.Models.ClientModel;
import com.iba.Services.exceptions.ServiceException;
import com.iba.Services.interfaces.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientDaoImpl clientDao;

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
}

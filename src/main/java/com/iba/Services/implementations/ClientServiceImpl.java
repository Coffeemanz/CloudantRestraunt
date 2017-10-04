package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.ClientDaoImpl;
import com.iba.Models.ClientModel;
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
        String id = clientDao.save(model);
        logger.debug("Client " + id + " successfully saved!");
        return id;
    }

    @Override
    public void delete(String id) {
        clientDao.delete(id);
        logger.debug("Client " + id + " successfully deleted!");
    }

    @Override
    public void update(ClientModel model) {
        clientDao.update(model);
        logger.debug("Client " + model.get_id() + " successfully updated");
    }

    @Override
    public List<ClientModel> getAll() {
        List<ClientModel> allModels = clientDao.getAll();
        logger.debug("All clients successfully found!");
        return allModels;
    }

    @Override
    public ClientModel getbyId(String id) {
        ClientModel clientModel = clientDao.getById(id);
        logger.debug("Client " + id + " successfully found");
        return clientModel;
    }
}

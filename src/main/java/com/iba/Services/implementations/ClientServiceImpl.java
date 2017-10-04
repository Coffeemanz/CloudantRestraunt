package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.ClientDaoImpl;
import com.iba.Models.ClientModel;
import com.iba.Services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDaoImpl clientDao;

    @Override
    public String save(ClientModel model) {
        return clientDao.save(model);
    }

    @Override
    public void delete(String id) {
        clientDao.delete(id);
    }

    @Override
    public void update(ClientModel model) {
        clientDao.update(model);
    }

    @Override
    public List<ClientModel> getAll() {
        List<ClientModel> allModels = clientDao.getAll();
        return allModels;
    }

    @Override
    public ClientModel getbyId(String id) {
        ClientModel clientModel = clientDao.getById(id);
        return clientModel;
    }
}

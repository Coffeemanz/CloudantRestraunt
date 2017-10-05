package com.iba.dao;


import com.iba.dao.dao.implementations.ClientDaoImpl;
import com.iba.models.ClientModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration("/test-context.xml")
@WebAppConfiguration
public class ClientDaoImplTest {

    @Autowired
    private ClientDaoImpl clientDao;

    private ClientModel clientActual;
    private ClientModel clientExpected;

    @Before
    public void init()
    {
        clientActual = new ClientModel(null, 777.0, null);
        clientExpected = new ClientModel();
    }

    @After
    public void destroy()
    {
        clientActual = null;
        clientExpected = null;
    }


    @Test
    public void testSave()
    {
        String id = clientDao.save(clientActual);
        clientExpected = clientDao.getById(id);
        clientActual = clientDao.getById(id);
        Assert.assertEquals("clientSave() failed", clientActual, clientExpected);
    }

    @Test
    public void testGetAll()
    {
        List<ClientModel> allDocs = clientDao.getAll();
        Assert.assertTrue("clientGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void testGetById()
    {
        List<ClientModel> allDocs = clientDao.getAll();
        clientActual = allDocs.get(0);
        clientExpected = clientDao.getById(clientActual.get_id());
        Assert.assertEquals("clientGetById() failed", clientActual, clientExpected);
    }

    @Test
    public void testUpdate()
    {
        clientActual = clientDao.getById("test_update");
        clientActual.setClient_cash(1234567.0);
        clientDao.update(clientActual);
        clientExpected = clientDao.getById("test_update");

        Assert.assertEquals("clientUpdate() failed", clientActual.getClient_cash(), clientExpected.getClient_cash());
    }

    @Test
    public void testDelete()
    {
        List<ClientModel> allDocs = clientDao.getAll();
        List<String> idS = new ArrayList<>();

        for (ClientModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            clientActual = clientDao.getById("test_delete");
            clientDao.delete("test_delete");
        }
        else
        {
            clientActual.set_id("test_delete");
            clientDao.save(clientActual);
        }

        Boolean deleted;

        List<ClientModel> allDocsAfterDelete = clientDao.getAll();

        if (!allDocsAfterDelete.contains(clientActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("clientDelete() failed", deleted);
    }
}

package com.iba.services;

import com.iba.models.ClientModel;
import com.iba.models.FoodModel;
import com.iba.services.exceptions.NotEnoughMoneyException;
import com.iba.services.exceptions.ServiceException;
import com.iba.services.implementations.ClientServiceImpl;
import com.iba.services.implementations.FoodServiceImpl;
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
public class ClientServiceImplTest {

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private FoodServiceImpl foodService;

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

    @Test(expected = ServiceException.class)
    public void save()
    {
        String id = clientService.save(clientActual);
        clientExpected = clientService.getbyId(id);
        clientActual = clientService.getbyId(id);
        Assert.assertEquals("clientSave() failed", clientActual, clientExpected);
    }

    @Test(expected = ServiceException.class)
    public void getAll()
    {
        List<ClientModel> allDocs = clientService.getAll();
        Assert.assertTrue("clientGetAll() failed", allDocs.size() >= 2);
    }

    @Test(expected = ServiceException.class)
    public void getById()
    {
        List<ClientModel> allDocs = clientService.getAll();
        clientActual = allDocs.get(0);
        clientExpected = clientService.getbyId(clientActual.get_id());
        Assert.assertEquals("clientGetById() failed", clientActual, clientExpected);
    }

    @Test(expected = ServiceException.class)
    public void update()
    {
        clientActual = clientService.getbyId("test_update");
        clientActual.setClient_cash(1234567.0);
        clientService.update(clientActual);
        clientExpected = clientService.getbyId("test_update");

        Assert.assertEquals("clientUpdate() failed", clientActual.getClient_cash(), clientExpected.getClient_cash());
    }

    @Test(expected = ServiceException.class)
    public void testDelete()
    {
        List<ClientModel> allDocs = clientService.getAll();
        List<String> idS = new ArrayList<>();

        for (ClientModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            clientActual = clientService.getbyId("test_delete");
            clientService.delete("test_delete");
        }
        else
        {
            clientActual.set_id("test_delete");
            clientService.save(clientActual);
        }

        Boolean deleted;

        List<ClientModel> allDocsAfterDelete = clientService.getAll();

        if (!allDocsAfterDelete.contains(clientActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("clientDelete() failed", deleted);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void getFood()
    {
        ClientModel clientModel = clientService.getbyId("test_service");
        FoodModel foodModel = foodService.getbyId("banana");


        String orderId = clientService.getFood(clientModel.get_id(), foodModel.get_id());

        Assert.assertNotNull("Should return order id", orderId);
    }
}
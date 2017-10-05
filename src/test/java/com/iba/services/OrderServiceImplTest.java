package com.iba.services;

import com.iba.models.OrderModel;
import com.iba.services.exceptions.ServiceException;
import com.iba.services.implementations.OrderServiceImpl;
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
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl OrderService;

    private OrderModel OrderActual;
    private OrderModel OrderExpected;

    @Before
    public void init()
    {
        OrderActual = new OrderModel(null, "11123", null);
        OrderExpected = new OrderModel();
    }

    @After
    public void destroy()
    {
        OrderActual = null;
        OrderExpected = null;
    }


    @Test(expected = ServiceException.class)
    public void testSave()
    {
        String id = OrderService.save(OrderActual);
        OrderExpected = OrderService.getbyId(id);
        OrderActual = OrderService.getbyId(id);
        Assert.assertEquals("OrderSave() failed", OrderActual, OrderExpected);
    }

    @Test(expected = ServiceException.class)
    public void testGetAll()
    {
        List<OrderModel> allDocs = OrderService.getAll();
        Assert.assertTrue("OrderGetAll() failed", allDocs.size() >= 2);
    }

    @Test(expected = ServiceException.class)
    public void testGetById()
    {
        List<OrderModel> allDocs = OrderService.getAll();
        OrderActual = allDocs.get(0);
        OrderExpected = OrderService.getbyId(OrderActual.get_id());
        Assert.assertEquals("OrderGetById() failed", OrderActual, OrderExpected);
    }

    @Test(expected = ServiceException.class)
    public void testUpdate()
    {
        OrderActual = OrderService.getbyId("test_update");
        OrderActual.setClient_id("77772");
        OrderService.update(OrderActual);
        OrderExpected = OrderService.getbyId("test_update");

        Assert.assertEquals("OrderUpdate() failed", OrderActual.getClient_id(), OrderExpected.getClient_id());
    }

    @Test(expected = ServiceException.class)
    public void testDelete()
    {
        List<OrderModel> allDocs = OrderService.getAll();
        List<String> idS = new ArrayList<>();

        for (OrderModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            OrderActual = OrderService.getbyId("test_delete");
            OrderService.delete("test_delete");
        }
        else
        {
            OrderActual.set_id("test_delete");
            OrderService.save(OrderActual);
        }

        Boolean deleted;

        List<OrderModel> allDocsAfterDelete = OrderService.getAll();

        if (!allDocsAfterDelete.contains(OrderActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("OrderDelete() failed", deleted);
    }
}

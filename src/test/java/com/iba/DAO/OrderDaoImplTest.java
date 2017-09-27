package com.iba.DAO;


import com.iba.DAO.dao.implementations.OrderDaoImpl;
import com.iba.Models.OrderModel;
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
public class OrderDaoImplTest {

    @Autowired
    OrderDaoImpl OrderDao;

    OrderModel OrderActual;
    OrderModel OrderExpected;

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


    @Test
    public void testSave()
    {
        Boolean saved = OrderDao.save(OrderActual);
        Assert.assertTrue("OrderSave() failed", saved);
    }

    @Test
    public void testGetAll()
    {
        List<OrderModel> allDocs = OrderDao.getAll();
        Assert.assertTrue("OrderGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void testGetById()
    {
        List<OrderModel> allDocs = OrderDao.getAll();
        OrderActual = allDocs.get(0);
        OrderExpected = OrderDao.getById(OrderActual.get_id());
        Assert.assertEquals("OrderGetById() failed", OrderActual, OrderExpected);
    }

    @Test
    public void testUpdate()
    {
        OrderActual = OrderDao.getById("test_update");
        OrderActual.setClient_id("77772");
        OrderDao.update(OrderActual);
        OrderExpected = OrderDao.getById("test_update");

        Assert.assertEquals("OrderUpdate() failed", OrderActual.getClient_id(), OrderExpected.getClient_id());
    }

    @Test
    public void testDelete()
    {
        List<OrderModel> allDocs = OrderDao.getAll();
        List<String> idS = new ArrayList<>();

        for (OrderModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            OrderActual = OrderDao.getById("test_delete");
            OrderDao.delete(OrderActual);
        }
        else
        {
            OrderActual.set_id("test_delete");
            OrderDao.save(OrderActual);
        }

        Boolean deleted;

        List<OrderModel> allDocsAfterDelete = OrderDao.getAll();

        if (!allDocsAfterDelete.contains(OrderActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("OrderDelete() failed", deleted);
    }
}

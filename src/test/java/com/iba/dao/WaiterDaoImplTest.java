package com.iba.dao;


import com.iba.dao.dao.implementations.WaiterDaoImpl;
import com.iba.models.WaiterModel;
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
public class WaiterDaoImplTest {

    @Autowired
    private WaiterDaoImpl WaiterDao;

    private WaiterModel WaiterActual;
    private WaiterModel WaiterExpected;

    @Before
    public void init()
    {
        WaiterActual = new WaiterModel("waiter_name");
        WaiterExpected = new WaiterModel();
    }

    @After
    public void destroy()
    {
        WaiterActual = null;
        WaiterExpected = null;
    }


    @Test
    public void testSave()
    {
        String id = WaiterDao.save(WaiterActual);
        WaiterExpected = WaiterDao.getById(id);
        WaiterActual = WaiterDao.getById(id);
        Assert.assertEquals("WaiterSave() failed", WaiterActual, WaiterExpected);
    }

    @Test
    public void testGetAll()
    {
        List<WaiterModel> allDocs = WaiterDao.getAll();
        Assert.assertTrue("WaiterGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void testGetById()
    {
        List<WaiterModel> allDocs = WaiterDao.getAll();
        WaiterActual = allDocs.get(0);
        WaiterExpected = WaiterDao.getById(WaiterActual.get_id());
        Assert.assertEquals("WaiterGetById() failed", WaiterActual, WaiterExpected);
    }

    @Test
    public void testUpdate()
    {
        WaiterActual = WaiterDao.getById("test_update");
        WaiterActual.setWaiter_name("77772");
        WaiterDao.update(WaiterActual);
        WaiterExpected = WaiterDao.getById("test_update");

        Assert.assertEquals("WaiterUpdate() failed", WaiterActual.getWaiter_name(), WaiterExpected.getWaiter_name());
    }

    @Test
    public void testDelete()
    {
        List<WaiterModel> allDocs = WaiterDao.getAll();
        List<String> idS = new ArrayList<>();

        for (WaiterModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            WaiterActual = WaiterDao.getById("test_delete");
            WaiterDao.delete("test_delete");
        }
        else
        {
            WaiterActual.set_id("test_delete");
            WaiterDao.save(WaiterActual);
        }

        Boolean deleted;

        List<WaiterModel> allDocsAfterDelete = WaiterDao.getAll();

        if (!allDocsAfterDelete.contains(WaiterActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("WaiterDelete() failed", deleted);
    }
}

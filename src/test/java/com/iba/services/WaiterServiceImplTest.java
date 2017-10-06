package com.iba.services;


import com.iba.models.WaiterModel;
import com.iba.services.exceptions.ServiceException;
import com.iba.services.implementations.WaiterServiceImpl;
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
public class WaiterServiceImplTest {

    @Autowired
    private WaiterServiceImpl WaiterService;

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
        String id = WaiterService.save(WaiterActual);
        WaiterExpected = WaiterService.getbyId(id);
        WaiterActual = WaiterService.getbyId(id);
        Assert.assertEquals("WaiterSave() failed", WaiterActual, WaiterExpected);
    }

    @Test
    public void testGetAll()
    {
        List<WaiterModel> allDocs = WaiterService.getAll();
        Assert.assertTrue("WaiterGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void testGetById()
    {
        List<WaiterModel> allDocs = WaiterService.getAll();
        WaiterActual = allDocs.get(0);
        WaiterExpected = WaiterService.getbyId(WaiterActual.get_id());
        Assert.assertEquals("WaiterGetById() failed", WaiterActual, WaiterExpected);
    }

    @Test
    public void testUpdate()
    {
        WaiterActual = WaiterService.getbyId("test_update");
        WaiterActual.setWaiter_name("waiterName");
        WaiterService.update(WaiterActual);
        WaiterExpected = WaiterService.getbyId("test_update");

        Assert.assertEquals("WaiterUpdate() failed", WaiterActual.getWaiter_name(), WaiterExpected.getWaiter_name());
    }

    @Test
    public void testDelete()
    {
        List<WaiterModel> allDocs = WaiterService.getAll();
        List<String> idS = new ArrayList<>();

        for (WaiterModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            WaiterActual = WaiterService.getbyId("test_delete");
            WaiterService.delete("test_delete");
        }
        else
        {
            WaiterActual.set_id("test_delete");
            WaiterService.save(WaiterActual);
        }

        Boolean deleted;

        List<WaiterModel> allDocsAfterDelete = WaiterService.getAll();

        if (!allDocsAfterDelete.contains(WaiterActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("WaiterDelete() failed", deleted);
    }
}

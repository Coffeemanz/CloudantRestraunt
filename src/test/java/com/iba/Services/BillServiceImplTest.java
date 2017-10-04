package com.iba.Services;


import com.iba.Models.BillModel;
import com.iba.Services.implementations.BillServiceImpl;
import com.iba.Services.interfaces.BillService;
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
public class BillServiceImplTest {

    @Autowired
    private BillServiceImpl billService;

    private BillModel billActual;
    private BillModel billExpected;

    @Before
    public void init()
    {
        billActual = new BillModel(null, 777.0, null);
        billExpected = new BillModel();
    }

    @After
    public void destroy()
    {
        billActual = null;
        billExpected = null;
    }

    @Test
    public void save()
    {
        String id = billService.save(billActual);
        billExpected = billService.getbyId(id);
        billActual = billService.getbyId(id);
        Assert.assertEquals("billSave() failed", billActual, billExpected);
    }

    @Test
    public void getAll()
    {
        List<BillModel> allDocs = billService.getAll();
        Assert.assertTrue("billGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void getById()
    {
        List<BillModel> allDocs = billService.getAll();
        billActual = allDocs.get(0);
        billExpected = billService.getbyId(billActual.get_id());
        Assert.assertEquals("billGetById() failed", billActual, billExpected);
    }

    @Test
    public void update()
    {
        billActual = billService.getbyId("test_update");
        billActual.setTotal_price(1234567.0);
        billService.update(billActual);
        billExpected = billService.getbyId("test_update");

        Assert.assertEquals("billUpdate() failed", billActual.getTotal_price(), billExpected.getTotal_price());
    }

    @Test
    public void testDelete()
    {
        List<BillModel> allDocs = billService.getAll();
        List<String> idS = new ArrayList<>();

        for (BillModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            billActual = billService.getbyId("test_delete");
            billService.delete("test_delete");
        }
        else
        {
            billActual.set_id("test_delete");
            billService.save(billActual);
        }

        Boolean deleted;

        List<BillModel> allDocsAfterDelete = billService.getAll();

        if (!allDocsAfterDelete.contains(billActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("billDelete() failed", deleted);
    }
}

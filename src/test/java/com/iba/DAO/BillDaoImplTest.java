package com.iba.DAO;


import com.iba.DAO.dao.implementations.BillDaoImpl;
import com.iba.DAO.dao.interfaces.BillDao;
import com.iba.Models.BillModel;
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
public class BillDaoImplTest {

    @Autowired
    private BillDaoImpl billDao;

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
    public void testSave()
    {
        String id = billDao.save(billActual);
        billExpected = billDao.getById(id);
        billActual = billDao.getById(id);
        Assert.assertEquals("billSave() failed", billActual, billExpected);
    }

    @Test
    public void testGetAll()
    {
        List<BillModel> allDocs = billDao.getAll();
        Assert.assertTrue("billGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void testGetById()
    {
        List<BillModel> allDocs = billDao.getAll();
        billActual = allDocs.get(0);
        billExpected = billDao.getById(billActual.get_id());
        Assert.assertEquals("billGetById() failed", billActual, billExpected);
    }

    @Test
    public void testUpdate()
    {
        billActual = billDao.getById("test_update");
        billActual.setTotal_price(1234567.0);
        billDao.update(billActual);
        billExpected = billDao.getById("test_update");

        Assert.assertEquals("billUpdate() failed", billActual.getTotal_price(), billExpected.getTotal_price());
    }

    @Test
    public void testDelete()
    {
        List<BillModel> allDocs = billDao.getAll();
        List<String> idS = new ArrayList<>();

        for (BillModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            billActual = billDao.getById("test_delete");
            billDao.delete("test_delete");
        }
        else
        {
            billActual.set_id("test_delete");
            billDao.save(billActual);
        }

        Boolean deleted;

        List<BillModel> allDocsAfterDelete = billDao.getAll();

        if (!allDocsAfterDelete.contains(billActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("billDelete() failed", deleted);
    }



}

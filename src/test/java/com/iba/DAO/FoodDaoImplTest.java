package com.iba.DAO;


import com.iba.DAO.dao.implementations.FoodDaoImpl;
import com.iba.Models.FoodModel;
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
public class FoodDaoImplTest {

    @Autowired
    FoodDaoImpl foodDao;

    FoodModel foodActual;
    FoodModel foodExpected;

    @Before
    public void init()
    {
        foodActual = new FoodModel(null, null, 777.0, null);
        foodExpected = new FoodModel();
    }

    @After
    public void destroy()
    {
        foodActual = null;
        foodExpected = null;
    }


    @Test
    public void testSave()
    {
        Boolean saved = foodDao.save(foodActual);
        Assert.assertTrue("foodSave() failed", saved);
    }

    @Test
    public void testGetAll()
    {
        List<FoodModel> allDocs = foodDao.getAll();
        Assert.assertTrue("foodGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void testGetById()
    {
        List<FoodModel> allDocs = foodDao.getAll();
        foodActual = allDocs.get(0);
        foodExpected = foodDao.getById(foodActual.get_id());
        Assert.assertEquals("foodGetById() failed", foodActual, foodExpected);
    }

    @Test
    public void testUpdate()
    {
        foodActual = foodDao.getById("test_update");
        foodActual.setFoood_price(1234567.0);
        foodDao.update(foodActual);
        foodExpected = foodDao.getById("test_update");

        Assert.assertEquals("foodUpdate() failed", foodActual.getFoood_price(), foodExpected.getFoood_price());
    }

    @Test
    public void testDelete()
    {
        List<FoodModel> allDocs = foodDao.getAll();
        List<String> idS = new ArrayList<>();

        for (FoodModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            foodActual = foodDao.getById("test_delete");
            foodDao.delete(foodActual);
        }
        else
        {
            foodActual.set_id("test_delete");
            foodDao.save(foodActual);
        }

        Boolean deleted;

        List<FoodModel> allDocsAfterDelete = foodDao.getAll();

        if (!allDocsAfterDelete.contains(foodActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("foodDelete() failed", deleted);
    }

}

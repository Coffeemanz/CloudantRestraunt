package com.iba.Services;

import com.iba.Models.FoodModel;
import com.iba.Services.implementations.FoodServiceImpl;
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
public class FoodServiceImplTest {

    @Autowired
    private FoodServiceImpl foodService;

    private FoodModel foodActual;
    private FoodModel foodExpected;

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
    public void save()
    {
        String id = foodService.save(foodActual);
        foodExpected = foodService.getbyId(id);
        foodActual = foodService.getbyId(id);
        Assert.assertEquals("foodSave() failed", foodActual, foodExpected);
    }

    @Test
    public void getAll()
    {
        List<FoodModel> allDocs = foodService.getAll();
        Assert.assertTrue("foodGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void getById()
    {
        List<FoodModel> allDocs = foodService.getAll();
        foodActual = allDocs.get(0);
        foodExpected = foodService.getbyId(foodActual.get_id());
        Assert.assertEquals("foodGetById() failed", foodActual, foodExpected);
    }

    @Test
    public void update()
    {
        foodActual = foodService.getbyId("test_update");
        foodActual.setFoood_price(1234567.0);
        foodService.update(foodActual);
        foodExpected = foodService.getbyId("test_update");

        Assert.assertEquals("foodUpdate() failed", foodActual.getFoood_price(), foodExpected.getFoood_price());
    }

    @Test
    public void testDelete()
    {
        List<FoodModel> allDocs = foodService.getAll();
        List<String> idS = new ArrayList<>();

        for (FoodModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            foodActual = foodService.getbyId("test_delete");
            foodService.delete("test_delete");
        }
        else
        {
            foodActual.set_id("test_delete");
            foodService.save(foodActual);
        }

        Boolean deleted;

        List<FoodModel> allDocsAfterDelete = foodService.getAll();

        if (!allDocsAfterDelete.contains(foodActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("foodDelete() failed", deleted);
    }
}

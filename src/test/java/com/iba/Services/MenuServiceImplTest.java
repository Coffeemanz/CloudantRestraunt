package com.iba.Services;

import com.iba.Models.MenuModel;
import com.iba.Services.implementations.MenuServiceImpl;
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
public class MenuServiceImplTest {

    @Autowired
    private MenuServiceImpl MenuService;

    private MenuModel MenuActual;
    private MenuModel MenuExpected;

    @Before
    public void init()
    {
        MenuActual = new MenuModel("test_menu");
        MenuExpected = new MenuModel();
    }

    @After
    public void destroy()
    {
        MenuActual = null;
        MenuExpected = null;
    }


    @Test
    public void testSave()
    {
        String id = MenuService.save(MenuActual);
        MenuExpected = MenuService.getbyId(id);
        MenuActual = MenuService.getbyId(id);
        Assert.assertEquals("MenuSave() failed", MenuActual, MenuExpected);
    }

    @Test
    public void testGetAll()
    {
        List<MenuModel> allDocs = MenuService.getAll();
        Assert.assertTrue("MenuGetAll() failed", allDocs.size() >= 2);
    }

    @Test
    public void testGetById()
    {
        List<MenuModel> allDocs = MenuService.getAll();
        MenuActual = allDocs.get(0);
        MenuExpected = MenuService.getbyId(MenuActual.get_id());
        Assert.assertEquals("MenuGetById() failed", MenuActual, MenuExpected);
    }

    @Test
    public void testUpdate()
    {
        MenuActual = MenuService.getbyId("test_update");
        MenuActual.setMenu_name("testing2");
        MenuService.update(MenuActual);
        MenuExpected = MenuService.getbyId("test_update");

        Assert.assertEquals("MenuUpdate() failed", MenuActual.getMenu_name(), MenuExpected.getMenu_name());
    }

    @Test
    public void testDelete()
    {
        List<MenuModel> allDocs = MenuService.getAll();
        List<String> idS = new ArrayList<>();

        for (MenuModel model: allDocs)
        {
            idS.add(model.get_id());
        }

        if (idS.contains("test_delete"))
        {
            MenuActual = MenuService.getbyId("test_delete");
            MenuService.delete(MenuActual);
        }
        else
        {
            MenuActual.set_id("test_delete");
            MenuService.save(MenuActual);
        }

        Boolean deleted;

        List<MenuModel> allDocsAfterDelete = MenuService.getAll();

        if (!allDocsAfterDelete.contains(MenuActual)) deleted = true;
        else deleted = false;

        Assert.assertTrue("MenuDelete() failed", deleted);
    }
}

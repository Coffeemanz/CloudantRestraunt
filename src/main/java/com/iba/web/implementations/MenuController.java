package com.iba.web.implementations;

import com.iba.models.MenuModel;
import com.iba.services.implementations.MenuServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menus")
@Api(tags = {"Menu Service"}, description = "Menu endpoints")
public class MenuController extends CrudController<MenuModel> {

    private MenuServiceImpl menuService;

    @Autowired
    public MenuController(MenuServiceImpl menuService)
    {
        super(menuService);
    }

}

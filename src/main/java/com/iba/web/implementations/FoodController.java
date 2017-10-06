package com.iba.web.implementations;


import com.iba.models.FoodModel;
import com.iba.services.implementations.FoodServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food")
@Api(tags = {"Food Service"}, description = "Food endpoints")
public class FoodController extends CrudController<FoodModel>{

    private FoodServiceImpl foodService;

    @Autowired
    public FoodController(FoodServiceImpl foodService)
    {
        super(foodService);
    }



}

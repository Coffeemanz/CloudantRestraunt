package com.iba.web.implementations;


import com.iba.models.FoodModel;
import com.iba.services.implementations.FoodServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food")
public class FoodController extends CrudController<FoodModel>{

    private FoodServiceImpl foodService;

    @Autowired
    public FoodController(FoodServiceImpl foodService)
    {
        this.foodService = foodService;
    }

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public ResponseEntity<String> saveFood(@RequestBody FoodModel foodModel)
//    {
//        return save(foodModel);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity updateFood(@RequestBody FoodModel foodModel, @PathVariable String id)
//    {
//        return update(foodModel);
//    }

    @Override
    public BaseService<FoodModel> getService() {
        return foodService;
    }


}

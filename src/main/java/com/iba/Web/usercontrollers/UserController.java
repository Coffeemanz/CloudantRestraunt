package com.iba.Web.usercontrollers;


import com.iba.Models.ClientModel;
import com.iba.Models.FoodModel;
import com.iba.Services.implementations.ClientServiceImpl;
import com.iba.Services.implementations.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class UserController {

    private ClientServiceImpl clientService;
    private FoodServiceImpl foodService;

    @Autowired
    public UserController (ClientServiceImpl clientService,
                           FoodServiceImpl foodService)
    {
        this.clientService = clientService;
        this.foodService = foodService;
    }

    @RequestMapping(value = "profile/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClientModel> userProfile(@PathVariable String id)
    {
        ClientModel clientModel = clientService.getbyId(id);
        return new ResponseEntity<ClientModel>(clientModel, HttpStatus.OK);
    }

    @RequestMapping(value = "food/{id}", method = RequestMethod.GET)
    public ResponseEntity<FoodModel> getFood(@PathVariable String id)
    {
        FoodModel foodModel = foodService.getbyId(id);
        return new ResponseEntity<FoodModel>(foodModel, HttpStatus.OK);
    }

    @RequestMapping(value = "food/all", method = RequestMethod.GET)
    public ResponseEntity<List<FoodModel>> getAllFood()
    {
        List<FoodModel> foodModels = foodService.getAll();
        return new ResponseEntity<List<FoodModel>>(foodModels, HttpStatus.OK);
    }
}

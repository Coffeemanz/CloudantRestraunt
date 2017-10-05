package com.iba.web.usercontrollers;


import com.iba.models.ClientModel;
import com.iba.models.FoodModel;
import com.iba.services.implementations.ClientServiceImpl;
import com.iba.services.implementations.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client/{clientId}")
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

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClientModel> userProfile(@PathVariable String id)
    {
        ClientModel clientModel = clientService.getbyId(id);
        return new ResponseEntity<ClientModel>(clientModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/food/{foodId}", method = RequestMethod.GET)
    public ResponseEntity<String> getFood(@PathVariable String clientId, @PathVariable String foodId)
    {
        String orderId = clientService.getFood(clientId, foodId);
        return new ResponseEntity<String>(orderId, HttpStatus.OK);
    }

    @RequestMapping(value = "/food/all", method = RequestMethod.GET)
    public ResponseEntity<List<FoodModel>> getAllFood()
    {
        List<FoodModel> foodModels = foodService.getAll();
        return new ResponseEntity<List<FoodModel>>(foodModels, HttpStatus.OK);
    }
}

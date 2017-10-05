package com.iba.dao;

import com.cloudant.client.api.CloudantClient;
import com.iba.dao.dao.implementations.BillDaoImpl;
import com.iba.models.BillModel;
import com.iba.models.ClientModel;
import com.iba.models.FoodModel;
import com.iba.models.OrderModel;
import com.iba.services.implementations.ClientServiceImpl;
import com.iba.services.implementations.FoodServiceImpl;
import com.iba.services.implementations.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration("/test-context.xml")
@WebAppConfiguration
public class Dao_tests {

    private static final Logger logger = LoggerFactory.getLogger(Dao_tests.class);

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    FoodServiceImpl foodService;

    @Autowired
    OrderServiceImpl orderService;
    @Test
    public void test(){

        ClientModel clientModel = clientService.getbyId("test_service");
        FoodModel foodModel = foodService.getbyId("banana");


        String orderId = clientService.getFood(clientModel.get_id(), foodModel.get_id());

        System.out.println("----------------------------");
        System.out.println(orderId);
        System.out.println("----------------------------");

    }
}

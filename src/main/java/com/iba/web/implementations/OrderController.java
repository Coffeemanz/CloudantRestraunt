package com.iba.web.implementations;

import com.iba.models.OrderModel;
import com.iba.services.implementations.OrderServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@Api(tags = {"Order Service"}, description = "Order endpoints")
public class OrderController extends CrudController<OrderModel> {

    private OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService)
    {
        super(orderService);
    }

}

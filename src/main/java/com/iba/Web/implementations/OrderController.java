package com.iba.Web.implementations;

import com.iba.Models.OrderModel;
import com.iba.Services.implementations.OrderServiceImpl;
import com.iba.Services.interfaces.BaseService;
import com.iba.Web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends CrudController<OrderModel> {

    private OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService)
    {
        this.orderService = orderService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> saveOrder(@RequestBody OrderModel orderModel)
    {
        return save(orderModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateOrder(@RequestBody OrderModel orderModel, @PathVariable String id)
    {
        return update(orderModel);
    }

    @Override
    protected BaseService<OrderModel> getService() {
        return orderService;
    }
}

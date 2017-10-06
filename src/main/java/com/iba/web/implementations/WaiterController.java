package com.iba.web.implementations;

import com.iba.models.WaiterModel;
import com.iba.services.implementations.WaiterServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/waiters")
public class WaiterController extends CrudController<WaiterModel> {


    private WaiterServiceImpl waiterService;

    @Autowired
    public WaiterController(WaiterServiceImpl waiterService)
    {
        super(waiterService);
    }

}

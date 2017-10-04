package com.iba.Web.implementations;

import com.iba.Models.WaiterModel;
import com.iba.Services.implementations.WaiterServiceImpl;
import com.iba.Services.interfaces.BaseService;
import com.iba.Web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/waiters")
public class WaiterController extends CrudController<WaiterModel> {


    private WaiterServiceImpl waiterService;

    @Autowired
    public WaiterController(WaiterServiceImpl waiterService)
    {
        this.waiterService = waiterService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> saveWaiter(@RequestBody WaiterModel waiterModel)
    {
        return save(waiterModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateWaiter(@RequestBody WaiterModel waiterModel, @PathVariable String id)
    {
        return update(waiterModel);
    }

    @Override
    protected BaseService<WaiterModel> getService() {
        return waiterService;
    }
}

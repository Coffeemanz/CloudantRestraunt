package com.iba.web.implementations;


import com.iba.models.BillModel;
import com.iba.services.implementations.BillServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
public class BillController extends CrudController<BillModel> {

    private BillServiceImpl billService;

    @Autowired
    public BillController(BillServiceImpl billService)
    {
        this.billService = billService;
    }

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public ResponseEntity<String> saveBill(@RequestBody BillModel billModel)
//    {
//        return save(billModel);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity updateBill(@RequestBody BillModel billModel, @PathVariable String id)
//    {
//        return update(billModel);
//    }

    @Override
    public BaseService<BillModel> getService() {
        return billService;
    }
}

package com.iba.Web.implementations;


import com.iba.Models.BaseModel;
import com.iba.Models.BillModel;
import com.iba.Services.implementations.BillServiceImpl;
import com.iba.Services.interfaces.BaseService;
import com.iba.Web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> saveBill(@RequestBody BillModel billModel)
    {
        return save(billModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateBill(@RequestBody BillModel billModel, @PathVariable String id)
    {
        return update(billModel);
    }

    @Override
    protected BaseService<BillModel> getService() {
        return billService;
    }
}

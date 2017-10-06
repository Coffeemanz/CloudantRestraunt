package com.iba.web.implementations;


import com.iba.models.BillModel;
import com.iba.services.implementations.BillServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
@Api(tags = {"Bill Service"}, description = "Bill endpoints")
public class BillController extends CrudController<BillModel> {

    public BillController(@Autowired BillServiceImpl billService)
    {
        super(billService);
    }

}

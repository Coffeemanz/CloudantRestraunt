package com.iba.web.implementations;

import com.iba.models.ClientModel;
import com.iba.services.implementations.ClientServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@Api(tags = {"Clients Service"}, description = "Clients endpoints")
public class ClientController extends CrudController<ClientModel>{

    private ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService)
    {
        super(clientService);
    }

}

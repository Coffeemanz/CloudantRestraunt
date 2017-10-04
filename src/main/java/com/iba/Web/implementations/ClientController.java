package com.iba.Web.implementations;

import com.iba.Models.ClientModel;
import com.iba.Services.implementations.ClientServiceImpl;
import com.iba.Services.interfaces.BaseService;
import com.iba.Web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController extends CrudController<ClientModel>{

    private ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService)
    {
        this.clientService = clientService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> saveClient(@RequestBody ClientModel clientModel)
    {
        return save(clientModel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateClient(@RequestBody ClientModel clientModel, @PathVariable String id)
    {
        return update(clientModel);
    }

    @Override
    protected BaseService<ClientModel> getService() {
        return clientService;
    }
}

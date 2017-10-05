package com.iba.web.implementations;

import com.iba.models.ClientModel;
import com.iba.services.implementations.ClientServiceImpl;
import com.iba.services.interfaces.BaseService;
import com.iba.web.abstracts.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public ResponseEntity<String> saveClient(@RequestBody ClientModel clientModel)
//    {
//        return save(clientModel);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity updateClient(@RequestBody ClientModel clientModel, @PathVariable String id)
//    {
//        return update(clientModel);
//    }

    @Override
    public BaseService<ClientModel> getService() {
        return clientService;
    }
}

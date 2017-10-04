package com.iba.Web.usercontrollers;

import com.iba.Models.ClientModel;
import com.iba.Services.implementations.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AllController {

    private ClientServiceImpl clientService;

    @Autowired
    public AllController(ClientServiceImpl clientService)
    {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody ClientModel client)
    {
        String id = clientService.save(client);
        return new ResponseEntity<String>(id, HttpStatus.CREATED);
    }
}

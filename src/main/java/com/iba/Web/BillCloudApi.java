package com.iba.Web;


import com.iba.DAO.dao.implementations.BillDaoImpl;
import com.iba.DAO.dao.interfaces.BillDao;
import com.iba.Models.BillModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api")
public class BillCloudApi {

    @Autowired
    BillDaoImpl billDao;

    @RequestMapping(method = RequestMethod.GET, value = "/bill", produces = "application/json")
    public ResponseEntity<String> test(){

        List<BillModel> billModels = new ArrayList<>();
        billModels = billDao.getAll();

        return new ResponseEntity<>(billModels.get(0).toString(), HttpStatus.OK);
    }
}

package com.iba.DAO;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.iba.DAO.dao.implementations.BillDaoImpl;
import com.iba.Models.BillModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration("/test-context.xml")
@WebAppConfiguration
public class Dao_tests {

    private static final Logger logger = LoggerFactory.getLogger(Dao_tests.class);
    @Autowired
    private CloudantClient client;

    @Autowired
    BillDaoImpl billDao;

    @Test
    public void test(){
//        System.out.println("-----------------------------------------");
//        System.out.println("Connected to Cloudant");
//        System.out.println("Server Version: " + client.serverVersion());
//        System.out.println("-----------------------------------------");
//
//        List<String> databases = client.getAllDbs();
//        System.out.println("-----------------------------------------");
//        System.out.println("All my databases : ");
//        for ( String db : databases ) {
//            System.out.println(db);
//        }
//        System.out.println("-----------------------------------------");



//        BillModel billModel = new BillModel("test_bill", "1-967a00dff5e02add41819138abb3284d");
//        Boolean saved = billDao.save(billModel);
//        System.out.println(saved);

//        billModel.setTotal_price(555.2);
//        billDao.update(billModel);


//        System.out.println(billDao.getAll().toString());
//
//        List<BillModel> billModels = billDao.getAll();
//
//        for (BillModel m: billModels)
//        {
//            System.out.println(m);
//        }

//        System.out.println("-----");
//
//        BillModel billModel = billDao.getById("bill1");
//
//        System.out.println(billDao.delete(billModel));
//
//        System.out.println("-----");
//

        BillModel billModel = new BillModel();
        String id = billDao.save(billModel);

        logger.info("testing logger");

    }
}

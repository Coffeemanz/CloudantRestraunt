package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.BillDaoImpl;
import com.iba.DAO.dao.interfaces.BillDao;
import com.iba.Models.BillModel;
import com.iba.Services.interfaces.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);

    @Autowired
    private BillDaoImpl billDao;

    @Override
    public String save(BillModel model) {
        String id = billDao.save(model);
        logger.debug("Bill " + id + " successfully saved!");
        return id;
    }

    @Override
    public void delete(String id) {
        billDao.delete(id);
        logger.debug("Bill " + id + " successfully deleted!");
    }

    @Override
    public void update(BillModel model) {
        billDao.update(model);
        logger.debug("Bill " + model.get_id() + " successfully updated");
    }

    @Override
    public List<BillModel> getAll() {
        List<BillModel> allModels = billDao.getAll();
        logger.debug("All bill successfully found!");
        return allModels;
    }

    @Override
    public BillModel getbyId(String id) {
        BillModel billModel = billDao.getById(id);
        logger.debug("Bill " + id + " successfully found");
        return billModel;
    }
}

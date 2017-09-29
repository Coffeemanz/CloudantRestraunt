package com.iba.Services.implementations;

import com.iba.DAO.dao.implementations.BillDaoImpl;
import com.iba.DAO.dao.interfaces.BillDao;
import com.iba.Models.BillModel;
import com.iba.Services.interfaces.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDaoImpl billDao;

    @Override
    public String save(BillModel model) {
        return billDao.save(model);
    }

    @Override
    public void delete(BillModel model) {
        billDao.delete(model);
    }

    @Override
    public void update(BillModel model) {
        billDao.update(model);
    }

    @Override
    public List<BillModel> getAll() {
        List<BillModel> allModels = billDao.getAll();
        return allModels;
    }

    @Override
    public BillModel getbyId(String id) {
        BillModel billModel = billDao.getById(id);
        return billModel;
    }
}

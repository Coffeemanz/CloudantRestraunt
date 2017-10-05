package com.iba.services.implementations;

import com.iba.dao.dao.implementations.BillDaoImpl;
import com.iba.dao.exceptions.DaoException;
import com.iba.models.BillModel;
import com.iba.services.exceptions.ServiceException;
import com.iba.services.interfaces.BillService;
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
        String id = null;
        try {
            id = billDao.save(model);
            logger.debug("Bill " + id + " successfully saved!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillService method save: " + e);
            throw new ServiceException(e);
        }
        return id;
    }

    @Override
    public void delete(String id) {
        try {
            billDao.delete(id);
            logger.debug("Bill " + id + " successfully deleted!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillService method delete: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(BillModel model) {
        try {
            billDao.update(model);
            logger.debug("Bill " + model.get_id() + " successfully updated");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillService method update: " + e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BillModel> getAll() {
        List<BillModel> allModels = null;
        try {
            allModels = billDao.getAll();
            logger.debug("All bill successfully found!");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillService method getAll: " + e);
            throw new ServiceException(e);
        }
        return allModels;
    }

    @Override
    public BillModel getbyId(String id) {
        BillModel billModel = null;
        try {
            billModel = billDao.getById(id);
            logger.debug("Bill " + id + " successfully found");
        } catch (DaoException e) {
            logger.error("Error was thrown in BillService method getById: " + e);
            throw new ServiceException(e);
        }
        return billModel;
    }
}

package com.iba.DAO.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.DAO.dao.interfaces.BaseDao;
import com.iba.Models.BillModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class BillDaoImpl extends AbstractDao<BillModel> implements BaseDao<BillModel> {

    public BillDaoImpl(@Autowired
                       @Qualifier("billDatabase")
                               Database billDb)
    {
        super(billDb, BillModel.class);
    }

}

package com.iba.dao.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.dao.dao.interfaces.BaseDao;
import com.iba.models.BillModel;
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

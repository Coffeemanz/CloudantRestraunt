package com.iba.dao.dao.implementations;

import com.cloudant.client.api.Database;
import com.iba.dao.dao.interfaces.BaseDao;
import com.iba.models.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends AbstractDao<ClientModel> implements BaseDao<ClientModel> {

    public ClientDaoImpl(@Autowired
                       @Qualifier("clientDatabase")
                               Database billDb)
    {
        super(billDb, ClientModel.class);
    }

}

package com.iba.services.validation;

import com.iba.models.ClientModel;
import com.iba.models.FoodModel;
import com.iba.services.exceptions.NotEnoughMoneyException;
import com.iba.services.implementations.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientMoneyValidation {

    @Autowired
    ClientServiceImpl clientService;

    public void validateMoney(ClientModel clientModel, FoodModel foodModel)
    {
        if (clientModel.getClient_cash() < foodModel.getFoood_price())
        {
            throw new NotEnoughMoneyException("Not enough money!");
        }
        else
        {
            clientModel.setClient_cash(clientModel.getClient_cash() - foodModel.getFoood_price());
            clientService.update(clientModel);
        }
    }
}

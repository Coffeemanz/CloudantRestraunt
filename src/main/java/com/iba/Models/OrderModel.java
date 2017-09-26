package com.iba.Models;

import java.util.ArrayList;

public class OrderModel extends BaseModel {

    private String waiter_id;
    private String client_id;
    private ArrayList<String> food_idS;

    public OrderModel() {
    }


    public OrderModel(String waiter_id, String client_id, ArrayList<String> food_idS) {
        this.waiter_id = waiter_id;
        this.client_id = client_id;
        this.food_idS = food_idS;
    }

    public String getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(String waiter_id) {
        this.waiter_id = waiter_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public ArrayList<String> getFood_idS() {
        return food_idS;
    }

    public void setFood_idS(ArrayList<String> food_idS) {
        this.food_idS = food_idS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderModel that = (OrderModel) o;

        if (waiter_id != null ? !waiter_id.equals(that.waiter_id) : that.waiter_id != null) return false;
        if (client_id != null ? !client_id.equals(that.client_id) : that.client_id != null) return false;
        return food_idS != null ? food_idS.equals(that.food_idS) : that.food_idS == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (waiter_id != null ? waiter_id.hashCode() : 0);
        result = 31 * result + (client_id != null ? client_id.hashCode() : 0);
        result = 31 * result + (food_idS != null ? food_idS.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "_id="+ get_id() +
                ", _rev=" + get_rev() +
                ", waiter_id='" + waiter_id + '\'' +
                ", client_id='" + client_id + '\'' +
                ", food_idS=" + food_idS +
                '}';
    }
}

package com.iba.Models;

import java.util.ArrayList;
import java.util.Date;

public class BillModel extends  BaseModel {

    private ArrayList<String> order_idS;
    private Double total_price;
    private Date date;

    public BillModel() {
    }

    public BillModel(ArrayList<String> order_idS, Double total_price, Date date) {
        this.order_idS = order_idS;
        this.total_price = total_price;
        this.date = date;
    }

    public ArrayList<String> getOrder_idS() {
        return order_idS;
    }

    public void setOrder_idS(ArrayList<String> order_idS) {
        this.order_idS = order_idS;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BillModel billModel = (BillModel) o;

        if (order_idS != null ? !order_idS.equals(billModel.order_idS) : billModel.order_idS != null) return false;
        if (total_price != null ? !total_price.equals(billModel.total_price) : billModel.total_price != null)
            return false;
        return date != null ? date.equals(billModel.date) : billModel.date == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (order_idS != null ? order_idS.hashCode() : 0);
        result = 31 * result + (total_price != null ? total_price.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BillModel{"+
                "_id="+ get_id() +
                ", _rev=" + get_rev() +
                ", order_idS=" + order_idS +
                ", total_price=" + total_price +
                ", date=" + date +
                '}';
    }
}

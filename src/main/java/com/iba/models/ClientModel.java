package com.iba.models;

public class ClientModel extends BaseModel {

    private String client_name;
    private Double client_cash;
    private Boolean paid;

    public ClientModel() {
    }

    public ClientModel(String client_name, Double client_cash, Boolean paid) {
        this.client_name = client_name;
        this.client_cash = client_cash;
        this.paid = paid;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public Double getClient_cash() {
        return client_cash;
    }

    public void setClient_cash(Double client_cash) {
        this.client_cash = client_cash;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ClientModel that = (ClientModel) o;

        if (client_name != null ? !client_name.equals(that.client_name) : that.client_name != null) return false;
        if (client_cash != null ? !client_cash.equals(that.client_cash) : that.client_cash != null) return false;
        return paid != null ? paid.equals(that.paid) : that.paid == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (client_name != null ? client_name.hashCode() : 0);
        result = 31 * result + (client_cash != null ? client_cash.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "_id="+ get_id() +
                ", _rev=" + get_rev() +
                ", client_name='" + client_name + '\'' +
                ", client_cash=" + client_cash +
                ", paid=" + paid +
                '}';
    }
}

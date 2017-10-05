package com.iba.models;

public class WaiterModel extends BaseModel {

    private String waiter_name;

    public WaiterModel()
    { }

    public WaiterModel(String waiter_name) {

        this.waiter_name = waiter_name;
    }

    public String getWaiter_name() {
        return waiter_name;
    }

    public void setWaiter_name(String waiter_name) {
        this.waiter_name = waiter_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WaiterModel that = (WaiterModel) o;

        return waiter_name != null ? waiter_name.equals(that.waiter_name) : that.waiter_name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (waiter_name != null ? waiter_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WaiterModel{" +
                "_id="+ get_id() +
                ", _rev=" + get_rev() +
                ", waiter_name='" + waiter_name + '\'' +
                '}';
    }
}

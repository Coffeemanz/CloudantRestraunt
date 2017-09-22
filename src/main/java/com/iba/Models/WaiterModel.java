package com.iba.Models;

public class WaiterModel extends BaseModel {

    private String waiter_name;

    public WaiterModel()
    {
        super();
    }

    public WaiterModel(String _id, String waiter_name) {
        super(_id);
        this.waiter_name = waiter_name;
    }

    public WaiterModel(String _id, String _rev, String waiter_name) {
        super(_id, _rev);
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
                "waiter_name='" + waiter_name + '\'' +
                '}';
    }
}

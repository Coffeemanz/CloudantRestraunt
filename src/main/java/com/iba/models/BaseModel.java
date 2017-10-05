package com.iba.models;

import java.io.Serializable;

public class BaseModel implements Serializable{

    private static final long SerialVersionUID = 1L;

    private String _id;
    private String _rev;

    public BaseModel(){};

    public BaseModel(String _id)
    {
        this._id = _id;
    }

    public BaseModel (String _id, String _rev)
    {
        this._id = _id;
        this._rev = _rev;
    }

    public String get_id() {

        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_rev() {
        return _rev;
    }

    public void set_rev(String _rev) {
        this._rev = _rev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        if (_id != null ? !_id.equals(baseModel._id) : baseModel._id != null) return false;
        return _rev != null ? _rev.equals(baseModel._rev) : baseModel._rev == null;
    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (_rev != null ? _rev.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "_id='" + _id + '\'' +
                ", _rev='" + _rev + '\'' +
                '}';
    }
}

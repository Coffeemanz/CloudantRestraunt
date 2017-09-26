package com.iba.Models;

public class MenuModel extends BaseModel{

    private String menu_name;

    public MenuModel() {
    }

    public MenuModel(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MenuModel menuModel = (MenuModel) o;

        return menu_name != null ? menu_name.equals(menuModel.menu_name) : menuModel.menu_name == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (menu_name != null ? menu_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MenuModel{" +
                "_id="+ get_id() +
                ", _rev=" + get_rev() +
                ", menu_name='" + menu_name + '\'' +
                '}';
    }
}

package com.iba.Models;

public class FoodModel extends BaseModel {

    private String food_name;
    private String food_desc;
    private Double foood_price;
    private String menu_id;

    public FoodModel() {
    }

    public FoodModel(String food_name, String food_desc, Double foood_price, String menu_id) {
        this.food_name = food_name;
        this.food_desc = food_desc;
        this.foood_price = foood_price;
        this.menu_id = menu_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_desc() {
        return food_desc;
    }

    public void setFood_desc(String food_desc) {
        this.food_desc = food_desc;
    }

    public Double getFoood_price() {
        return foood_price;
    }

    public void setFoood_price(Double foood_price) {
        this.foood_price = foood_price;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FoodModel foodModel = (FoodModel) o;

        if (food_name != null ? !food_name.equals(foodModel.food_name) : foodModel.food_name != null) return false;
        if (food_desc != null ? !food_desc.equals(foodModel.food_desc) : foodModel.food_desc != null) return false;
        if (foood_price != null ? !foood_price.equals(foodModel.foood_price) : foodModel.foood_price != null)
            return false;
        return menu_id != null ? menu_id.equals(foodModel.menu_id) : foodModel.menu_id == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (food_name != null ? food_name.hashCode() : 0);
        result = 31 * result + (food_desc != null ? food_desc.hashCode() : 0);
        result = 31 * result + (foood_price != null ? foood_price.hashCode() : 0);
        result = 31 * result + (menu_id != null ? menu_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "_id="+ get_id() +
                ", _rev=" + get_rev() +
                ", food_name='" + food_name + '\'' +
                ", food_desc='" + food_desc + '\'' +
                ", foood_price=" + foood_price +
                ", menu_id='" + menu_id + '\'' +
                '}';
    }
}

package edu.diegod.models;

/**
 * Created by diego-d on 8/3/15.
 */
public class Product {
    private String name;
    private String code;
    private int quantity;
    private float cost;
    private float price;

    public Product(String name, String code, int quantity, float cost, float price) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCode() {
        return code;
    }

    public float getPrice() {
        return price;
    }

    public float getCost() {
        return cost;
    }

    public String getTableValueAtIndex(int columnIndex){
        switch (columnIndex){
            case 0:
                return name;
            case 1:
                return code;
            case 2:
                return String.valueOf(quantity);
            case 3:
                return String.valueOf(cost);
            case 4:
                return String.valueOf(price);
            default:
                return "desconocido";
        }
    }
}

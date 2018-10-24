package tech.bts.onlineshop.model;


public class Product {

    private long id;
    private String name;
    private String brand;
    private double price;
    private int quantity;

    // Convention, constants are written in upper case in Java
    public final static long NOT_SPECIFIED = -1;

    public Product(String name, String brand, double price) {
        this.id = NOT_SPECIFIED;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price + "$";
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {

        return this.quantity > 0;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

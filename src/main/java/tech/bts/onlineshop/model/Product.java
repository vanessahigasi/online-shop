package tech.bts.onlineshop.model;


public class Product {

    private long id;
    private String name;
    private double price;
    private boolean available;

    // Convention, constants are written in upper case in Java
    public final static long NOT_SPECIFIED = -1;

    public Product(String name, double price) {
        this.id = NOT_SPECIFIED;
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

}

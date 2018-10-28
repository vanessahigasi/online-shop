package tech.bts.onlineshop.model;

public class Discount {

    private String id;
    private String name;
    private double amount;
    private boolean percentage;

    public Discount() {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.percentage = percentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPercentage() {
        return percentage;
    }

    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }


}

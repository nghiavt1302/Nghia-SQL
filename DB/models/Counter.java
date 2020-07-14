package vn.plusplus.database.models;

public class Counter {
    private String maker;
    private int quantity;

    public Counter() {
    }

    public Counter(String maker, int quantity) {
        this.maker = maker;
        this.quantity = quantity;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

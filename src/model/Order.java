package model;

import java.util.List;

public class Order {
    private int soBan;
    private List<String> mon;

    Order(){}

    public Order(int soBan, List<String> mon) {
        this.soBan = soBan;
        this.mon = mon;
    }

    public int getSoBan() {
        return soBan;
    }

    public List<String> getMon() {
        return mon;
    }
}

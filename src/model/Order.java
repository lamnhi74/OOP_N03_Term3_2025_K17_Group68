package model;

import java.util.ArrayList;

public class Order {
    private String idBan;
    private double viTri;

    public Order(String idBan, double viTri){
        this.idBan=idBan;
        this.viTri=viTri;
    }

    public Order(){}

    public String getIDBan(){
        return idBan;
    }
    public void setID(String idBan){
        this.idBan=idBan;
    }
    public double getViTri(){
        return viTri;
    }
    public void setViTri(double viTri){
        this.viTri=viTri;
    }
    
    private ArrayList<Dish> list = new ArrayList<Dish>();
    public void addDish(Dish dish) {
        list.add(dish);
        System.out.println("Da them vao don hang: " + dish.getTen());
    }

    public ArrayList<Dish> getList() {
    return list;
    }
}
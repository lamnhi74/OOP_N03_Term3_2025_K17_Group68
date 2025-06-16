package model;

public class Bill{
    private String id;
    private String tenKH;
    private double tongTien;
    private Order order;

    public Bill(String tenKH){
        this.tenKH=tenKH;
        this.order=new Order();
    }
    
    public Bill(){};

    public String getid(){
        return id;
    }
    public String getTenKH(){
        return tenKH;
    }
    public double getTongTien(){
        return tongTien;
    }
    public void setid(String id){
        this.id=id;
    }
    public void setMonAn(String tenKH){
        this.tenKH=tenKH;
    }
    public void setTongTien(double tongTien){
        this.tongTien=tongTien;
    }

    public void addDishToOrder(Dish dish) {
        order.addDish(dish);
    }

    public void printBill() {
    System.out.println("===== Hoa don cua " + tenKH + " =====");
    for (Dish dish : order.getList()) {
        System.out.println(dish);
    }
    }
}
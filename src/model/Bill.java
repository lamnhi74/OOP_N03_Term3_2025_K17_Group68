package model;

public class Bill{
    private String id;
    private double tongTien;
    private Order order;

    public Bill(String tenKH){
        this.order=new Order();
    }
    
    public Bill(){};

    public String getid(){
        return id;
    }
    public double getTongTien(){
        return tongTien;
    }
    public void setid(String id){
        this.id=id;
    }
    public void setTongTien(double tongTien){
        this.tongTien=tongTien;
    }

    public void printBill() {
    System.out.println("========== HÓA ĐƠN ==========");
    System.out.println("Khách hàng: " + order.getTenKH());
    System.out.println("Danh sách món đã gọi:");
    for (Dish dish : order.getDishOrder()) {
        System.out.println("Ten: " + dish.getTen() + " | Gia: " + dish.getGia() + " VND");
    }
    order.total();
    System.out.println("TỔNG TIỀN: " + tongTien + " VND");
    System.out.println("=============================");
    }
}
package model;
import java.util.ArrayList;

public class Order {
    public String tenKH;
    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    ArrayList<Table> tableOrder = new ArrayList<Table>();
    public ArrayList<Table> addTable(Table table) {
        tableOrder.add(table);
        System.out.println("Da them ban moi: " + table.getViTri());
        return tableOrder;
    }
    
    Menu menu = new Menu();
    public void addMenu(){
        menu.printMenu();
    }

    ArrayList<Dish> dish = menu.getAllDishes();

    ArrayList<Dish> dishOrder = new ArrayList<>();    
    public void addDishToOrder(Dish dish) {
        dishOrder.add(dish);
        System.out.println("Đã thêm món: " + dish.getTen());
    }

    public ArrayList<Dish> getDishOrder() { 
        return dishOrder; 
    }

    public double total(){
        double sum = 0;
        for (Dish dish : dishOrder) {
            sum += dish.getGia();
        }
        return sum;
    }
}
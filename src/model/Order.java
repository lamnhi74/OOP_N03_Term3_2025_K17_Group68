package model;
import java.util.ArrayList;

public class Order {
    ArrayList<Table> order = new ArrayList<Table>();
    public ArrayList<Table> addTable(Table table) {
        order.add(table);
        System.out.println("Da them ban moi: " + table.getViTri());
        System.out.println("Nhập tên khách hàng: " + table.getTenKH());

        Menu menu = new Menu();
        menu.printMenu();

        ArrayList<Dish> dishes = menu.getAllDishes();

        ArrayList<Dish> dishOrder = new ArrayList<>();    
        dishOrder.add(dish);
        System.out.println("Đã thêm món: " + dish.getTen());

        for (Dish dish : dishOrder) {
            System.out.println("Đã thêm món: " + d.getTen());
        }

        double sum = 0;
        for (Dish dish : dishOrder) {
            sum += dish.getGia();
        }
    
    return order;
    }
}
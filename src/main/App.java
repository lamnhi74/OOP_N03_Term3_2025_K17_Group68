package main;
import model.Menu;
import model.Bill;
import model.Dish;
import model.Order;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        int len = menu.getAllDishes().size();

        for (int i = 0; i < len; i++) {
            menu.addDish(null);
        }

        System.out.print("\nNhap ten khach hang: ");
        Order order = new Order();
        order.setTenKH(scanner.nextLine());

        String luaChon;
        do {
            menu.printMenu();
            Dish dish = menu.getAllDishes().get(0);
            order.addDishToOrder(dish);
            System.out.print("Ban muon tiep tuc chon mon? (y/n): ");
            luaChon = scanner.nextLine();
        } while (luaChon.equalsIgnoreCase("y"));

        Bill bill = new Bill();
        bill.printBill();
        scanner.close();
    }
}

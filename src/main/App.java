package main;
import model.Menu;
import model.Bill;
import model.Dish;
import model.Order;

import java.util.Scanner;
import java.util.Collection;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        int len = menu.size();

        for (int i = 0; i < len; i++) {
            menu.addDish(null);
        }

        System.out.print("\nNhap ten khach hang: ");
        String name = scanner.nextLine();
        Order order = new Order();

        String luaChon;
        do {
            menu.printMenu();
            order.addDishToOrder(Dish);
            System.out.print("Ban muon tiep tuc chon mon? (y/n): ");
            luaChon = scanner.nextLine();
        } while (luaChon.equalsIgnoreCase("y"));

        Bill bill = new Bill();
        bill.printBill();
        scanner.close();
    }
}

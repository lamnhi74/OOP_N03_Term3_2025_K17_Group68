package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dish dish = Dish.createDish(scanner);
        System.out.println("Ban da tao mon an: " + dish);
    }

    ArrayList <Dish> menu = new ArrayList<Dish>();
    public ArrayList<Dish> addDish(Dish dish){
        menu.add(dish);
        System.out.println("Da them mon: " + dish.getTen());
        return menu;
    }

    public void printMenu() {
        int len = menu.size();
        for (int i = 0; i < len; i++) {
            Dish dish = menu.get(i);
            System.out.println("Dish: " + " Name: " + dish.ten + " Price: " + dish.gia + " Type: " + dish.danhMuc);
        }
    }

    public ArrayList<Dish> getAllDishes() {
        return menu;
    }

    public ArrayList<Dish> editDish(String id, double gia) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).id == id) {
                System.out.print("true");
                menu.get(i).gia = gia;
            }
        }
        return menu;
    }
}
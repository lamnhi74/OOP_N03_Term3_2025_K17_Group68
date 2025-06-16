package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList <Dish> list = new ArrayList<Dish>();
    public ArrayList<Dish> addDish(Dish dish) {
        Scanner scanner = new Scanner(System.in);
        String id = null;
        String ten = null;
        double gia = 0;
        String danhMuc = null;
        try {
            System.out.println("Moi ban nhap id mon an");
            id = scanner.nextLine();
            System.out.println("Moi ban nhap ten mon an");
            ten = scanner.nextLine();
            System.out.println("Moi ban nhap gia mon an");
            gia = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Moi ban nhap danh muc mon an");
            danhMuc = scanner.nextLine();
            System.out.println("");
        } finally {
            scanner.close();
        }
        dish = new Dish(id, ten, gia, danhMuc);
        list.add(dish);
        System.out.println("Da them mon: " + ten);
        return list;
    }

    public void showMenu() {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            Dish dish = list.get(i);
            System.out.println("Dish: " + dish.getId() + " Name: " + dish.getTen() + " Price: " + dish.getGia() + " Type: " + dish.getDanhMuc());

        }

    }

    public ArrayList<Dish> editDish(String id, double gia) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                System.out.print("true");
                list.get(i).setGia(gia);
            }

        }
        return list;
    }

}
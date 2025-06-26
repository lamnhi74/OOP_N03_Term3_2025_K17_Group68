package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList <Dish> menu = new ArrayList<Dish>();

    public void createDish() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mời bạn nhập ID món ăn: ");
            String id = scanner.nextLine();
            System.out.println("Mời bạn nhập tên món ăn: ");
            String ten = scanner.nextLine();
            System.out.println("Mời bạn nhập giá món ăn: ");
            double gia = Double.parseDouble(scanner.nextLine());
            scanner.nextLine();
            System.out.println("Mời bạn nhập danh mục món ăn: ");
            String danhMuc = scanner.nextLine();
            menu.add(new Dish(id, ten, gia, danhMuc));
        } catch (Exception e) { 
            System.out.println("Lỗi khi tạo món ăn: " + e.getMessage());
            return;
        } finally {
            System.out.println("Đã tạo món ăn.");
        }
    }

    public ArrayList<Dish> getAllDishes() {
        return menu;
    }

    public void printMenu() {
        int len = menu.size();
        for (int i = 0; i < len; i++) {
            Dish dish = menu.get(i);
            System.out.println("Món ăn: " + " Tên: " + dish.ten + " Giá: " + dish.gia + " Danh mục: " + dish.danhMuc);
        }
    }

    public ArrayList<Dish> editDish(String id) {
        double gia = 0;
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).id == id) {
                System.out.print("true");
                menu.get(i).gia = gia;
            }
        }
        return menu;
    }
}
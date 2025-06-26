package main;
import model.Menu;
import model.Bill;
import model.Dish;
import model.Order;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        int choice = 0;
        Menu menu = new Menu();
        do{
            System.out.println("----------Quản Lý Nhà Hàng----------");
            System.out.println("1. Tạo món ăn mới");
            System.out.println("2. Sửa thông tin món ăn");
            System.out.println("3. In Menu");
            System.out.println("4. Thoát");
            System.out.println("------------------------------------");
            System.out.println("Chọn chức năng");
            
            Scanner scanner = new Scanner(System.in);
            choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1: menu.createDish();
                    break;
                case 2:
                    System.out.println("Nhập ID cần sửa: ");
                    String id = scanner.nextLine(); 
                    menu.editDish(id);
                    break;
                case 3: menu.printMenu();
                    break;
                case 4: 
                    break;
                default: System.out.println("Chọn sai chức năng");
                    break;
            }
        }while (choice != 4);
    }
}

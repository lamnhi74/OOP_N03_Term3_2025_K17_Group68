<<<<<<< HEAD
package main;
import model.Menu;
import model.Bill;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nNhap ten khach hang: ");
        String tenKH = scanner.nextLine();
        Bill bill = new Bill(tenKH);

        Menu menu = new Menu();
        String luaChon;
        do {
            menu.showMenu();
            System.out.print("Nhap ID mon an ban muon chon (hoac 'x' de thoat): ");
            String id = scanner.nextLine();
            if (id.equalsIgnoreCase("x")) break;

            System.out.print("Ban muon tiep tuc chon mon? (y/n): ");
            luaChon = scanner.nextLine();
        } while (luaChon.equalsIgnoreCase("y"));

        scanner.close();
        bill.printBill();
=======
package src.main;
import model.MonAn;

public class App {
    public static void main(String[] args) {
        MonAn monAn = new MonAn("Cơm Tấm", 35000, "Cơm tấm sườn bì chả", "Món chính");
        System.out.println("Chào mừng đến với thực đơn!");
        System.out.println("Thông tin món ăn đang chọn:");
        hienThiMonAn(monAn);
    }
    public static void hienThiMonAn(MonAn mon) {
        System.out.println("Tên: " + mon.getTen());
        System.out.println("Giá: " + mon.getGia());
        System.out.println("Mô tả: " + mon.getMoTa());
        System.out.println("Danh mục: " + mon.getDanhMuc());
>>>>>>> 4772d24974edbd5faf2188df8b315765bd1b0c68
    }
}

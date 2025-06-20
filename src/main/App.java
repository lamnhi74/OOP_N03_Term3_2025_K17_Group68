
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
    }
}

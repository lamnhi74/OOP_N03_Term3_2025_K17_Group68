package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BillData {
    public static void xuLyDon(Order order) {
        System.out.println("📣 Gửi đơn đến bếp - Bàn " + order.getSoBan());
        for (String dish : order.getMon()) {
            System.out.println(" - " + mon);
        }

        try (FileWriter DL = new FileWriter("orders.txt", true)) {
            DL.write("Bàn " + order.getSoBan() + ": " + String.join(", ", order.getMon()) + "\n");
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu đơn hàng.");
        }
    }
}

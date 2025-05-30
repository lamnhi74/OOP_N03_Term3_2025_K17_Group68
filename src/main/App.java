// Source code is decompiled from a .class file using FernFlower decompiler.
package main;
import model.MonAn;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("Chào mừng đến với thực đơn!");
        System.out.println("Thông tin món ăn đang chọn:");
        ArrayList<MonAn> danhSachMon = new ArrayList<>();
            danhSachMon.add(new MonAn("00029", "Pho bo", 40000, "Mon chinh"));
            danhSachMon.add(new MonAn("00036", "nem chua", 15000, "Mon phu"));
            danhSachMon.add(new MonAn("00075", "Bun bo Hue", 40000, "Mon chinh"));
            for(MonAn mon : danhSachMon){
                mon.hienThiMonAn();
            }
    }
}

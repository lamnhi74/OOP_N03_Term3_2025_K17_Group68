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
    }
}

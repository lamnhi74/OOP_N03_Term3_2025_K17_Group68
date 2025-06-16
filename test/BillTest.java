package test;
import model.MonAn;
public class BillTest {
    public static void main(String[] args) {
        MonAn mon = new MonAn("00029","Phở bò", 40000, "Món chính");
        System.out.println("==Test==");
        mon.hienThiMonAn();
        System.out.println("Thanh Cong");
    }
}

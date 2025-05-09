public class donhang {
    public static void main(String[] args) {
        Hoadon hoadon = new hoadon();
        monan mon1 = new monan("M01", "Phở bò", 45000, "Món chính");
        monan mon2 = new monan("D01", "Trà đá", 5000, "Đồ uống");

        hoadon.addmon(mon1);
        hoadon.addmon(mon2);

        System.out.println("Tổng tiền: " + hoadon.tinhtong());
    }
}

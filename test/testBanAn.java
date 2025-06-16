package test.java;

import main.java.model.BanAn;

public class testBanAn {

    public static void DatBan(double viTri){
        System.out.println("Đặt bàn số: " +viTri);
    }
    public void capNhatTrangThai(String trangThai){
        System.out.println("Trạng thái: " +trangThai);
    }
}
ArrayList <Menu> list = new ArrayList<Menu>();
    public ArrayList<Menu> addDish(Menu dish) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("");
        list.add(dish);
        return list;
    }

    public void printMenu() {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            System.out.println("Dish: " + list.get(i).id + " Name: " + list.get(i).ten + " Price: " + list.get(i).gia + " Type: " + list.get(i).danhMuc );

        }

    }

    public ArrayList<Menu> editDish(double gia) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).gia == gia) {
                System.out.print("true");
                list.get(i).gia = gia;
            }

        }
        return list;
    }
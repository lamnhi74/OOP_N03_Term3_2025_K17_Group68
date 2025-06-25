package test;
import model.Dish;
import model.Menu;
public class BillTest {
    public static void main(String[] args) {
        Dish dish = new Dish("00029","Phở bò", 40000, "Món chính");
        System.out.println("==Test==");
        dish.printMenu();
        System.out.println("Thanh Cong");
    }
}

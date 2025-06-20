package model;
import java.io.*;

public class MenuData {
    public static void save(Dish dish, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(dish);
            System.out.println("Da luu mon an vao Menu: " +filename);
        } catch (IOException e){
            System.err.println("Loi khi in file: " +e.getMessage());
        }
    }
    public static Menu load(String filename) {
         try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            Menu menu = (Menu) in.readObject();
            System.out.println("Da doc Menu tu file: " +filename);
            return menu;
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Loi khi doc file: " +e.getMessage());
            return new Menu();
        }
    }
}

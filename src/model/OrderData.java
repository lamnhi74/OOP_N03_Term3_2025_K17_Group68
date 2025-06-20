package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OrderData {
    public static void save(Bill bill, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(bill);
            System.out.println("Da luu hoa don: " +filename);
        } catch (IOException e){
            System.err.println("Loi khi in file: " +e.getMessage());
        }
    }
    public static Bill load(String filename) {
         try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            Bill bill = (Bill) in.readObject();
            System.out.println("Da doc Menu tu file: " +filename);
            return bill;
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Loi khi doc file: " +e.getMessage());
            return new Bill();
        }
    }
}

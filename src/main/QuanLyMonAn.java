// Source code is decompiled from a .class file using FernFlower decompiler.
package main;
import model.MonAn;
import java.util.Scanner;

public class QuanLyMonAn {
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        MonAn mon = new MonAn();
        mon.nhapMon(scanner);
        mon.inMon();
        mon.themMon();
        mon.xoaMon();
        scanner.close();
    }
}

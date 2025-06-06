package model;

import java.util.ArrayList;
import java.util.Scanner;

public class MonAn {
    private String id;
    private String ten;
    private double gia;
    private String danhMuc;

    public MonAn(){}

    public String getid() { 
        return id; 
    }
    public void setid(String id) { 
        this.id = id; 
    }

    public String getten() { 
        return ten; 
    }
    public void setten(String ten) { 
        this.ten = ten; 
    }

    public double getgia() { 
        return gia; 
    }
    public void setgia(double gia) { 
        this.gia = gia; 
    }
     
    public String getdanhMuc() { 
        return danhMuc; 
    }
    public void setdanhMuc(String danhMuc) { 
        this.danhMuc = danhMuc; 
    }

    public void nhapMon(Scanner input){
        System.out.println("Moi ban nhap id mon an");
        id = input.nextLine();
        System.out.println("Moi ban nhap ten mon an");
        ten = input.nextLine();
        System.out.println("Moi ban nhap gia mon an");
        gia = input.nextDouble();
        input.nextLine();
        System.out.println("Moi ban nhap danh muc mon an");
        danhMuc = input.nextLine();
    }

    public void inMon(){
        System.out.println("Mon An Id "+id+" Ten "+ten+" Gia "+gia+" thuoc "+danhMuc+"");
    }

    ArrayList<MonAn> mon = new ArrayList<MonAn>();
    public ArrayList<MonAn> themMon(MonAn ma) {
        mon.add(ma);
        return mon;
    }

    public ArrayList<MonAn> xoaMon(String id) {
        for (int i = 0; i < mon.size(); i++) {
            if (mon.get(i).id == id) {
                mon.remove(i);
            }
        }
        return mon;
    }
}
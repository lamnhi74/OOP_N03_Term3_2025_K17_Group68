package model;
import java.util.Scanner;

public class NhanVien {
    private String id;
    private String hoTen;
    private String chucVu;

    public NhanVien(){}

    public void nhapThongTin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Moi ban nhap id nhan vien");
        id = input.nextLine();
        System.out.println("Moi ban nhap ho ten nhan vien");
        hoTen = input.nextLine();
        System.out.println("Moi ban nhap chuc vu nhan vien");
        chucVu = input.nextLine();
    }

    public void inThongTin(){
        System.out.println("Nhan vien Id "+id+" Ten "+hoTen+" chuc vu "+chucVu+"");
    }

    public String getid() { 
        return id; 
    }
    public void setid(String id) { 
        this.id = id; 
    }

    public String getHoTen() { 
        return hoTen; 
    }
    public void setHoTen(String hoTen) { 
        this.hoTen = hoTen; 
    }

    public String getChucVu() { 
        return chucVu; 
    }
    public void setChucVu(String chucVu) { 
        this.chucVu = chucVu; 
    }
}

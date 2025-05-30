package model;
public class MonAn {
    private String id;
    private String ten;
    private double gia;
    private String danhMuc;
    public MonAn(){}
    public MonAn(String id, String ten, double gia, String danhMuc){
        this.id=id;
        this.ten=ten;
        this.gia=gia;
        this.danhMuc=danhMuc;
    }
    public String getid() { return id; }
    public void setid(String id) { this.id = id; }

    public String getten() { return ten; }
    public void setten(String ten) { this.ten = ten; }

    public double getgia() { return gia; }
    public void setgia(double gia) { this.gia = gia; }
     
    public String getdanhMuc() { return danhMuc; }
    public void setdanhMuc(String danhMuc) { this.danhMuc = danhMuc; }

    public static void hienThiMonAn(MonAn mon) {
        System.out.println("ID: " + mon.getid());
        System.out.println("Tên: " + mon.getten());
        System.out.println("Giá: " + mon.getgia());
        System.out.println("Danh mục: " + mon.getdanhMuc());
    }
}
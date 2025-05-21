package model;
public class MonAn {
    private String ten;
    private double gia;
    private String moTa;
    private String danhMuc;
    public MonAn(){}
    public MonAn(String ten, double gia, String moTa, String danhMuc){
        this.ten=ten;
        this.gia=gia;
        this.moTa=moTa;
        this.danhMuc=danhMuc;
    }
    public String getTen(){
        return ten;
    }
    public double getGia(){
        return gia;
    }
    public String getMoTa(){
        return moTa;
    }
    public String getDanhMuc(){
        return danhMuc;
    }
    public void setTen(String ten){
        this.ten=ten; 
    }
     public void setGia(double gia){
        this.gia=gia;
    }
     public void setMoTa(String moTa){
        this.moTa=moTa;
    }
     public void setDanhMuc(String danhMuc){
        this.danhMuc=danhMuc;
    }
}
@Override
public String toString() {
    return "MonAn{" +
           "ten='" + ten + '\'' +
           ", gia=" + gia +
           ", moTa='" + moTa + '\'' +
           ", danhMuc='" + danhMuc + '\'' +
           '}';
}
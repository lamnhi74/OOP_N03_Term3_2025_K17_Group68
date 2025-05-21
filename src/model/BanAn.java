package model;
public class BanAn {
    private double viTri;
    private String trangThai;
    public BanAn(){}
    public BanAn(double viTri, String trangThai){
        this.viTri=viTri;
        this.trangThai=trangThai;
    }
    public double getViTri(){
        return viTri;
    }
    public String getTrangThai(){
        return trangThai;
    }
    public void setViTri(double viTri){
        this.viTri=viTri;
    }
    public void setTrangThai(String trangThai){
        this.trangThai=trangThai;
    }
}
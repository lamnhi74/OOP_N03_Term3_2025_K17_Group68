package model;
public class BanAn {
    private String id;
    private double viTri;
    private String trangThai;

    public BanAn(){}

     public String getid(){
        return id;
    }
    public void setid(String id){
        this.id=id;
    }
    public double getViTri(){
        return viTri;
    }
    public void setViTri(double viTri){
        this.viTri=viTri;
    }
    public String getTrangThai(){
        return trangThai;
    }
    public void setTrangThai(String trangThai){
        this.trangThai=trangThai;
    }
}
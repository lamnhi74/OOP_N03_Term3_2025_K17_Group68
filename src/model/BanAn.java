package model;
public class BanAn {
    private String id;
    private double viTri;
    private String trangThai;
    public BanAn(){}
    public BanAn(String id, double viTri, String trangThai){
        this.id=id;
        this.viTri=viTri;
        this.trangThai=trangThai;
    }
     public double getid(){
        return id;
    }
    public double getViTri(){
        return viTri;
    }
    public String getTrangThai(){
        return trangThai;
    }
    public void setid(String id){
        this.id=id;
    }
    public void setViTri(double viTri){
        this.viTri=viTri;
    }
    public void setTrangThai(String trangThai){
        this.trangThai=trangThai;
    }
}
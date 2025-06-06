package model;
public class HoaDon{
    private String id;
    private String monAn;
    private double viTri;
    private double tongTien;
    
    public HoaDon(){};

    public String getid(){
        return id;
    }
    public String getMonAn(){
        return monAn;
    }
    public double getViTri(){
        return viTri;
    }
    public double getTongTien(){
        return tongTien;
    }
    public void setid(String id){
        this.id=id;
    }
    public void setMonAn(String monAn){
        this.monAn=monAn;;
    }
    public void setViTri(double viTri){
        this.viTri=viTri;
    }
    public void setTongTien(double tongTien){
        this.tongTien=tongTien;
    }
}
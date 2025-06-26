package model;

public class Table {
    public String idBan;
    public int viTri;
    public String tenKH;

    public Table(String idBan, int viTri, String tenKH){
        this.idBan=idBan;
        this.viTri=viTri;
        this.tenKH=tenKH;
    }

    public Table(){}

    public String getIdBan(){
        return idBan;
    }
    public void setID(String idBan){
        this.idBan=idBan;
    }
    public int getViTri(){
        return viTri;
    }
    public void setViTri(int viTri){
        this.viTri=viTri;
    }
    public String getTenKH() {
        return tenKH;
    }
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
}

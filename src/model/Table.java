package model;

public class Table {
    public String idBan;
    public int viTri;

    public Table(String idBan, int viTri){
        this.idBan=idBan;
        this.viTri=viTri;
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
}

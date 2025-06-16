package model;

public class Dish {
    private String id;
    private String ten;
    private double gia;
    private String danhMuc;

    public Dish(String id, String ten, double gia, String danhMuc){
        this.id=id;
        this.ten=ten;
        this.gia=gia;
        this.danhMuc=danhMuc;
    }

    public Dish(){}

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }

    public String getTen() { 
        return ten; 
    }
    public void setTen(String ten) { 
        this.ten = ten; 
    }

    public double getGia() { 
        return gia; 
    }
    public void setGia(double gia) { 
        this.gia = gia; 
    }
     
    public String getDanhMuc() { 
        return danhMuc; 
    }
    public void setDanhMuc(String danhMuc) { 
        this.danhMuc = danhMuc; 
    }

    public String toString() {
        return id + " - " + ten + " - " + gia + " VND - " + danhMuc;
    }
}

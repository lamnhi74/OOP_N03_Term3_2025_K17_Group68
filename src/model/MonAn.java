package src.model;

public class MonAn {
    private String id;
    private String ten;
    private double gia;
    private String moTa;
    private String danhMuc;
    public MonAn(){}
    public MonAn(String id, String ten, double gia, String moTa, String danhMuc){
        this.id=id;
        this.ten=ten;
        this.gia=gia;
        this.moTa=moTa;
        this.danhMuc=danhMuc;
    }
    public String getid() { return id; }
    public void setid(String id) { this.id = id; }

    public String getten() { return ten; }
    public void setten(String ten) { this.ten = ten; }

    public double getgia() { return gia; }
    public void setgia(double gia) { this.gia = gia; }

    public String getmoTa() { return moTa; }
    public void setmoTa(String moTa) { this.moTa = moTa; }
     
    public String getdanhMuc() { return danhMuc; }
    public void setdanhMuc(String danhMuc) { this.danhMuc = danhMuc; }
}


public class MonAnList {

    ArrayList<MonAn> ma = new ArrayList<MonAn>();

    public ArrayList<MonAn> addMonAn(MonAn mon) {

        ma.add(mon);
        return ma;

    }

    public ArrayList<MonAn> getEditMonAn(String ten, double gia, String moTa, String danhMuc) {

        for (int i = 0; i < ma.size(); i++) {

            if (ma.get(i).ten == ten) {

                System.out.print("true");

                ma.get(i).gia = gia;
                ma.get(i).moTa = moTa;
                ma.get(i).danhMuc = danhMuc;
            }

        }

        return ma;
    }

    public ArrayList<MonAn> getDeleteMonAn(Sting ten) {

        for (int i = 0; i < ma.size(); i++) {

            if (ma.get(i).ten == ten) {

                st.remove(i);

            }

        }

        return st;
    }

    public void printStudentList() {
        int len = st.size();

        for (int i = 0; i < len; i++) {
            System.out.println("Student ID: " + st.get(i).studentId + " Fullnane: " + st.get(i).fullname);

        }

    }
}
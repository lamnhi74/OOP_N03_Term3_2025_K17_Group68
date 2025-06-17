package src.model;

public class BanAn {
    private String id;
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


public class BanAn {

    ArrayList<BanAn> ba = new ArrayList<BanAn>();

    public ArrayList<BanAn> addBanAn(BanAn ban) {

        ba.add(ban);
        return ban;

    }

    public ArrayList<BanAn> getEditBanAn(double viTri, String trangThai) {

        for (int i = 0; i < ba.size(); i++) {

            if (ba.get(i).viTri == viTri) {

                System.out.print("true");

                ba.get(i).trangThai = trangThai;
            }

        }

        return ba;
    }

    public ArrayList<Banan> getDeleteBanAn(double viTri) {

        for (int i = 0; i < ba.size(); i++) {

            if (ba.get(i).viTri == viTri) {

                ba.remove(i);

            }

        }

        return st;
    }

    public void printBanAnList() {
        int len = ba.size();

        for (int i = 0; i < len; i++) {
            System.out.println("Vi tri: " + st.get(i).viTri + " Trang thai: " + st.get(i).trangThai);

        }

    }
}
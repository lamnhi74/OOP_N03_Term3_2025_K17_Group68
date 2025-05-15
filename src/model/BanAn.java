package model;
class BanAn {
    double viTri;
    String trangThai;
    BanAn(){};
    BanAn(double viTri, String trangThai){
        this.viTri=viTri;
        this.trangThai=trangThai;
    }
    public void DatBan(double viTri){
        System.out.println("Đặt bàn số: " +viTri);
    }
    public void capNhatTrangThai(String trangThai){
        System.out.println("Trạng thái: " +trangThai);
    }
}
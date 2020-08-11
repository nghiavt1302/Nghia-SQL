package Lesson7.models;

public class Thong_tin_NCC {
    String ma_NCC;
    String ten_NCC;
    String address;
    String sdt;
    String ma_so_thue;

    public Thong_tin_NCC(){
    }

    public Thong_tin_NCC(String ma_NCC, String ten_NCC, String address, String sdt, String ma_so_thue) {
        this.ma_NCC = ma_NCC;
        this.ten_NCC = ten_NCC;
        this.address = address;
        this.sdt = sdt;
        this.ma_so_thue = ma_so_thue;
    }

    public String getMa_NCC() {
        return ma_NCC;
    }

    public void setMa_NCC(String ma_NCC) {
        this.ma_NCC = ma_NCC;
    }

    public String getTen_NCC() {
        return ten_NCC;
    }

    public void setTen_NCC(String ten_NCC) {
        this.ten_NCC = ten_NCC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMa_so_thue() {
        return ma_so_thue;
    }

    public void setMa_so_thue(String ma_so_thue) {
        this.ma_so_thue = ma_so_thue;
    }

    @Override
    public String toString() {
        return "Thong_tin_NCC{" +
                "ma_NCC='" + ma_NCC + '\'' +
                ", ten_NCC='" + ten_NCC + '\'' +
                ", address='" + address + '\'' +
                ", sdt='" + sdt + '\'' +
                ", ma_so_thue='" + ma_so_thue + '\'' +
                '}';
    }
}

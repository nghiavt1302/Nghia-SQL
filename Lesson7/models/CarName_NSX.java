package Lesson7.models;

public class CarName_NSX {
    String ten_xe;
    String hang_xe;

    public CarName_NSX(){
    }

    public CarName_NSX(String ten_xe, String hang_xe) {
        this.ten_xe = ten_xe;
        this.hang_xe = hang_xe;
    }

    public String getTen_xe() {
        return ten_xe;
    }

    public void setTen_xe(String ten_xe) {
        this.ten_xe = ten_xe;
    }

    public String getHang_xe() {
        return hang_xe;
    }

    public void setHang_xe(String hang_xe) {
        this.hang_xe = hang_xe;
    }
}

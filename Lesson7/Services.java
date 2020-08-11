package Lesson7;

import Lesson7.models.CarName_NSX;
import Lesson7.models.Thong_tin_NCC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Services {
    Connection connection;

    public Services(){
    }

    public Services(Connection connection){
        this.connection = connection;
    }
//Act 7.1
    public void Liet_ke_xe_tren_5_cho_ngoi(){
        String sql = "SELECT Dongxe FROM dongxe WHERE SoChoNgoi>5";
        List<String> danh_sach_xe = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                CarName_NSX carName_nsx = new CarName_NSX(resultSet.getString(1), null);
                danh_sach_xe.add(carName_nsx.getTen_xe());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for(int i =0;i < danh_sach_xe.size(); i++){
            System.out.println(danh_sach_xe.get(i));
        }
    }
//Act 7.2
    public void liet_ke_thong_tin_NCC(){
        List<Thong_tin_NCC> thong_tin_nccs = new ArrayList<>();
        try{
            String sql ="";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//Act 7.5
    public void Liet_ke_hang_xe(){
        List<String> hang_xe =new ArrayList<>();
        String sql = "SELECT DISTINCT HangXe FROM dongxe";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                CarName_NSX carName_nsx = new CarName_NSX(null, resultSet.getString(1));
                hang_xe.add(carName_nsx.getHang_xe());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for(int i =0;i < hang_xe.size(); i++){
            System.out.println(hang_xe.get(i));
        }
    }
}

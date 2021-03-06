package vn.plusplus.database.services;

import vn.plusplus.database.models.LaptopModel;
import vn.plusplus.database.models.Counter;
import vn.plusplus.database.models.Statistic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopService {
    private Connection con;

    public LaptopService() {
    }

    public LaptopService(Connection connection) {
        this.con = connection;
    }

    public List<LaptopModel> findAllByMaker(String maker) {
        String sql = "SELECT * FROM laptop WHERE maker='" + maker + "'";
        List<LaptopModel> laptopEntities = queryDatabase(sql);
        return laptopEntities;
    }

    // Activity 3.1
//tim kiem Laptop theo khoang gia
    public List<LaptopModel> findByPrice(Long fromPrice, Long toPrice) {
        String sql = "";
        if (fromPrice != null && toPrice == null) {
            sql = "SELECT * FROM laptop WHERE price>=" + fromPrice;
        } else if (fromPrice == null && toPrice != null) {
            sql = "SELECT * FROM laptop WHERE price<=" + toPrice;
        } else if (fromPrice != null && toPrice != null) {
            sql = "SELECT * FROM laptop WHERE price BETWEEN " + fromPrice + " AND " + toPrice;
        }
        List<LaptopModel> laptopEntities = queryDatabase(sql);
        return laptopEntities;
    }

//tim kiem Laptop theo hang
    public List<LaptopModel> searchByMaker(String maker){
        String sql = "SELECT * FROM laptop WHERE TRUE";
        if(maker != null){
            sql += " AND maker='" + maker +"'";
        }
        System.out.println(sql);
        List<LaptopModel> response = queryDatabase(sql);
        return response;
    }
//tim kiem laptop thep loai O cung
    public List<LaptopModel> searchByHardDriveType(String hdd){
        String sql = "SELECT * FROM laptop WHERE TRUE";
        if(hdd != null){
            sql += " AND hdd'" + hdd +"'";
        }
        System.out.println(sql);
        List<LaptopModel> response = queryDatabase(sql);
        return response;
    }
//Activity 3.2
    public List<LaptopModel> searchLaptop(Float fromPrice, Float toPrice, String maker, String screen_size,
                                           String ram, String cpu, String hdd, String ssd, String type, String card, String order){
        String sql = "SELECT * FROM laptop WHERE TRUE";
        if(fromPrice != null){
            sql += " AND price >="+ fromPrice;
        }
        if(toPrice != null){
            sql += " AND price <=" + toPrice;
        }
        if(maker != null){
            sql += " AND maker='" + maker + "'";
        }
        if(screen_size != null){
            sql += " AND screen_resolution='" + screen_size + "'";
        }
        if(ram != null){
            sql += " AND ram='" + ram + "'";
        }
        if(cpu != null){
            sql += " AND cpu LIKE '%" + cpu + "%'";
        }
        if(hdd != null){
            sql += " AND hdd='" + hdd + "'";
        }
        if(ssd != null){
            sql += " AND ssd='" + ssd +"'";
        }
        if(type != null){
            sql += " AND type='" + type + "'";
        }
        if(card != null){
            sql += " AND card='" + card + "'";
        }
        if(order != null){
            if(order.equals("ASC")){
                sql += " ORDER BY price ASC";
            } else {
                sql += " ORDER BY price DESC";
            }
        }

        System.out.println(sql);
        List<LaptopModel> response = queryDatabase(sql);
        return response;
    }
//Activity 33
    public List<LaptopModel> findBySoldDESC(){
        queryDatabase("SELECT * FROM laptop ORDER BY sold DESC");
        return null;
    }
//Acitivity 41
    public List<Counter> getCounterByMaker() {
        try {
            List<Counter> counters = new ArrayList<>();
            String sql = "SELECT maker, count (*) AS quantity WHERE laptop GROUP BY maker ORDER BY quantity DESC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Counter counter = new Counter(rs.getString(1), rs.getInt(2));
                counters.add(counter);
            }
            return counters;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
//Activity 42
    public List<Statistic> getStatisticByMaker(String maker){
        try {
            List<Statistic> statistics = new ArrayList<>();
            String sql = "SELECT SUM(sold) AS `slod`, SUM(price*sold) AS `totalMoney` FROM store_cms_plusplus.laptop WHERE maker = '" + maker + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Statistic statistic = new Statistic(maker, rs.getInt(1), rs.getInt(2));
                statistics.add(statistic);
            }
            return statistics;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
//Activity 51  (em chua viet dc chuc nang test)
    public void Insert_Laptop_into_DB() {
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT IGNORE INTO laptop (" +
                    "name, " + "url, " + "maker, " + "type, " + "ram, " + "cpu, " + "ssd, " + "hdd, " + "price, " + "card, " + "screen_resolution, " + "screen_size, " + "sold)" + " VALUES('Dell Inspiron 3593-70197459'," +
                    " 'https://phongvu.vn/may-tinh-xach-tay-laptop-dell-inspiron-15-3593-3593-70197459-i7-1065g7-en-s191100002.html', " + "'Dell', 'Inspiron'," + " \" +\n" + " \"'8GB', 'Intel Core i7-1065G7 ', '256GB', '1TB', '24990000', 'NVIDIA GeForce MX230 2GB GDDR5 ', '1920 x 1080', '15.6', '30')\"; ";
            stmt.executeUpdate(sql);
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM laptop WHERE name ='Dell Inspiron 3593-70197459'");
            List<LaptopModel> laptopModels=new ArrayList<>();
            while(resultSet.next()){
                LaptopModel laptopModel= new LaptopModel(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)
                        ,resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),
                        resultSet.getString(8),resultSet.getString(9),resultSet.getFloat(10),resultSet.getString(11),
                        resultSet.getString(12),resultSet.getString(13),resultSet.getInt(14),null,null);
                laptopModels.add(laptopModel);

                for(LaptopModel laptopModel1 : laptopModels){
                    System.out.println("Da tim thay " + laptopModel1.toString() + "trong CSDL");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
// Activity52
    public void Update_quantity_by_time(int so_luong_tang_them){
        try{
            String sql = "UPDATE laptop SET sold=sold+" + so_luong_tang_them + "WHERE maker =''Dell AND type ='Dell Inspiron'";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private List<LaptopModel> queryDatabase(String sql){
        List<LaptopModel> laptopModels = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                LaptopModel laptopModel = new LaptopModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getFloat(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getTimestamp(15),
                        rs.getTimestamp(16)
                );
                laptopModels.add(laptopModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return laptopModels;
    }

}

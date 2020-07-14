
package vn.plusplus.database;

import vn.plusplus.database.models.Counter;
import vn.plusplus.database.models.LaptopModel;
import vn.plusplus.database.services.LaptopService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ApplicationLaptop {
    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://35.198.211.159:3306/store_cms_plusplus?characterEncoding=utf8", "root", "kiemnx"); // em dang dung DB cua anh Kiem
            System.out.println("SQL Connection to database established!");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console"  + e);
            return;
        }
        LaptopService laptopService = new LaptopService(connection);
        List<LaptopModel> result = laptopService.searchLaptop(15000000.0f, null, null, null, null,
                "intel", null, null, null, null, "DESC");

        for(LaptopModel entity : result){
            System.out.println(entity.toString());
        }
        List<Counter> counters = laptopService.getCounterByMaker();
    }
}

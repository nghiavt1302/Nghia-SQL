package Lesson7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("JDBC not found");
        }
        try {
            Connection connection = null;
            connection = DriverManager.getConnection("jdbc:mysql://35.198.211.159:3306/thue_xe_cms?characterEncoding=utf8mb4", "root", "kiemnx");
        } catch (SQLException throwables) {
            System.out.println("Connection Failed! Check output console"  + throwables);;
        }
    }
}

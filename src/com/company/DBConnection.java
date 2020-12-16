package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            try {
                return DriverManager.getConnection("jdbc:postgresql://localhost:5432/quanlykho", "quanlykhouser","123456");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

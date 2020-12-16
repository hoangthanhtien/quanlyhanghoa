package com.company;

import model.IvtUser;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public void initialize() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quanlykho", "quanlykhouser","123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM role");
            System.out.println("id  name");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + "   " + name);

            }
        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }

    public static void main(String[] args) {
        new Main().initialize();

    }

}

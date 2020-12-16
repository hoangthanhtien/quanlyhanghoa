package controller;

import com.company.DBConnection;
import model.IvtUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IvtUserController {
    public static boolean login(String email, String password){
        Connection conn = DBConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ivtuser WHERE email='"+email+"' AND password='"+password+"'");
            while (rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static ArrayList<IvtUser> getAllUser(){
        ArrayList<IvtUser> list = new ArrayList<>();

        Connection conn = DBConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ivtuser");
            while(rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                IvtUser user = new IvtUser(id, username, password, email);
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}

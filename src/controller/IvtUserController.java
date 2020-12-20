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
    public static boolean checkEmailExists(String email){
        Connection conn = DBConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ivtuser WHERE email='"+email+"'");
            while (rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static void signUp(String username, String email, String password){
        Connection conn = DBConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            if(username == null){
                username = email;
            }
            int rs = st.executeUpdate("insert into ivtuser(username, email, password) values('" + username + "','" + email + "','"+password+"')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static ArrayList<IvtUser> getAllUser(){
        ArrayList<IvtUser> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try { Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ivtuser");
            while(rs.next()){ int id = rs.getInt("id");
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

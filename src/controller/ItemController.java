package controller;

import com.company.DBConnection;
import model.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemController {
    public static boolean createNewItem(String itemName, String barcode) {
        Connection conn = DBConnection.getConnection();
        if(itemName == "" || barcode == ""){
            return false;
        }
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("insert into item(item_name, barcode) values('" + itemName + "','" + barcode + "')");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

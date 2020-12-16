package controller;

import com.company.DBConnection;
import model.Item;

import javax.swing.table.DefaultTableModel;
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
            int rs = st.executeUpdate("insert into item(item_name, barcode) values('" + itemName + "','" + barcode + "')");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static DefaultTableModel getItemDataToTable(){
        Connection conn = DBConnection.getConnection();
        Object[][] rowData = new Object[20][3];
        Object columnNames[] = {"ID", "Tên hàng hóa", "Mã vạch"};
        try {
            int i = 0;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item");
            while(rs.next()){
                rowData[i][0] = rs.getInt("item_no");
                rowData[i][1] = rs.getString("item_name");
                rowData[i][2] = rs.getString("barcode");
                i++;
            }
            conn.close();
        }catch (SQLException e){
           e.printStackTrace();
        }
        DefaultTableModel tableModel  = new DefaultTableModel(rowData, columnNames);
        return tableModel;
    }
}

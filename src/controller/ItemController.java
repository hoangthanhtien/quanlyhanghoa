package controller;

import com.company.DBConnection;
import model.Item;

import javax.swing.plaf.nimbus.State;
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
    public static String getItemNameById(int item_no){
        Connection conn = DBConnection.getConnection();
        String item_name = "";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item where item_no="+item_no+"");
            while(rs.next()){
               item_name = rs.getString("item_name");
            }
            return item_name;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return item_name;
    }
    public static DefaultTableModel getItemDataToTable(){
        Connection conn = DBConnection.getConnection();
        int record_num = ItemController.countItemRecord();
        Object[][] rowData = new Object[record_num][3];
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
    public static int countItemRecord(){
        Connection conn = DBConnection.getConnection();
        int record_num = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from item");
            while(rs.next()){
                record_num = rs.getInt("count");
            }
            return record_num;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return record_num;
    }
    public static int getLastItemId(){
        Connection conn = DBConnection.getConnection();
        int last_item_id = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item");
            while(rs.next()){
                last_item_id = rs.getInt("item_no");
            }
            return last_item_id;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return last_item_id;
    }
}

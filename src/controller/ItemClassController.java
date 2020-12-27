package controller;

import com.company.DBConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemClassController {

    public static boolean createNewItemClass(String itemClassName) {
        Connection conn = DBConnection.getConnection();
        if(itemClassName == ""){
            return false;
        }
        try {
            Statement st = conn.createStatement();
            int rs = st.executeUpdate("insert into item_class(item_class_name) values('" + itemClassName + "')");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static String getItemClassNameById(int item_class_id){
        Connection conn = DBConnection.getConnection();
        String item_class_name = "";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item_class where item_class_id="+item_class_id+"");
            while(rs.next()){
                item_class_name = rs.getString("item_class_name");
            }
            return item_class_name;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return item_class_name;
    }
    public static DefaultTableModel getItemClassDataToTable(){
        Connection conn = DBConnection.getConnection();
        int record_num = ItemController.countItemRecord();
        Object[][] rowData = new Object[record_num][2];
        Object columnNames[] = {"ID", "Tên nhóm hàng hóa"};
        try {
            int i = 0;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item_class");
            while(rs.next()){
                rowData[i][0] = rs.getInt("item_class_id");
                rowData[i][1] = rs.getString("item_class_name");
                i++;
            } conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DefaultTableModel tableModel  = new DefaultTableModel(rowData, columnNames);
        return tableModel;
    }
    public static int countItemClassRecord(){
        Connection conn = DBConnection.getConnection(); int record_num = 0; try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from item_class");
            while(rs.next()){
                record_num = rs.getInt("count");
            }
            return record_num;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return record_num;
    }
    public static int getLastItemClassId(){
        Connection conn = DBConnection.getConnection();
        int last_item_id = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from item_class");
            while(rs.next()){
                last_item_id = rs.getInt("item_class_id");
            }
            return last_item_id;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return last_item_id;
    }}

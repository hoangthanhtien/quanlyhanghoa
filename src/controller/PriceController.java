package controller;

import com.company.DBConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PriceController {
    public static boolean createNewPrice(int price_type, float price_before_vat, float vat, float price_after_vat, int item_no, int active, int supplier_id, int price_list_id) {
        Connection conn = DBConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            int rs = st.executeUpdate("insert into price(price_type, price_before_vat, vat, price_after_vat, item_no, active, supplier_id, price_list_id) values('" + price_type + "','" + price_before_vat + "','"+ vat +"','" + price_after_vat +"','"+item_no+"','"+active+"','"+supplier_id+"','"+price_list_id+"')");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static DefaultTableModel getPriceDataToTable(){
        Connection conn = DBConnection.getConnection();
        int record_num = PriceController.countPriceRecord();
        Object[][] rowData = new Object[record_num][4];
        Object columnNames[] = {"ID", "Tên hàng hóa", "Giá trước vat", "Giá sau vat","" };
        try {
            int i = 0;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from supplier");
            while(rs.next()){
                rowData[i][0] = rs.getInt("supplier_id");
                rowData[i][1] = rs.getString("supplier_name");
                rowData[i][2] = rs.getString("supplier_phone");
                rowData[i][3] = rs.getString("supplier_address");
                i++;
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DefaultTableModel tableModel  = new DefaultTableModel(rowData, columnNames);
        return tableModel;
    }
    public static int countPriceRecord(){
        Connection conn = DBConnection.getConnection();
        int record_num = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from price");
            while(rs.next()){
                record_num = rs.getInt("count");
            }
            return record_num;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return record_num;
    }
    public static int getLastPriceId(){
        Connection conn = DBConnection.getConnection();
        int last_price_id = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from price");
            while(rs.next()){
                last_price_id = rs.getInt("price_id");
            }
            return last_price_id;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return last_price_id;
    }
}

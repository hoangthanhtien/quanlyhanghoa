package controller;
import com.company.DBConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PriceList {
    public static void addPriceList(String price_list_name) {
        Connection conn = DBConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            int rs = st.executeUpdate("insert into pricelist(price_list_name) values('" + price_list_name + "')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean checkPriceListNameDuplication(String price_list_name) {
        Connection conn = DBConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pricelist WHERE price_list_name='" + price_list_name + "'");
            while (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static DefaultTableModel getPriceListDataToTable(){
        Connection conn = DBConnection.getConnection();
        int record_num = PriceList.countPriceListRecord();
        Object[][] rowData = new Object[record_num][3];
        Object columnNames[] = {"ID", "Tên bảng giá"};
        try {
            int i = 0;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pricelist");
            while(rs.next()){
                rowData[i][0] = rs.getInt("price_list_id");
                rowData[i][1] = rs.getString("price_list_name");
                i++;
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        DefaultTableModel tableModel  = new DefaultTableModel(rowData, columnNames);
        return tableModel;
    }
    public static int countPriceListRecord(){
        Connection conn = DBConnection.getConnection();
        int record_num = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from pricelist");
            while(rs.next()){
                record_num = rs.getInt("count");
            }
            return record_num;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return record_num;
    }
    public static int getLastPriceListId(){
        Connection conn = DBConnection.getConnection();
        int last_price_list_id = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pricelist");
            while(rs.next()){
                last_price_list_id = rs.getInt("price_list_id");
            }
            return last_price_list_id;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return last_price_list_id;
    }
}
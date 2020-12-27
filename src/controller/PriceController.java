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
    public static DefaultTableModel getPriceDataToTable(int price_list_id){
        Connection conn = DBConnection.getConnection();
        int record_num = PriceController.countPriceRecord();
        Object[][] rowData = new Object[record_num][9];
        Object columnNames[] = {"ID", "Tên hàng hóa", "Giá trước vat", "Vat", "Giá sau vat","Nhà cung cấp", "Bảng giá", "Loại giá", "Hiệu lực" };
        try {
            int i = 0;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from price where price_list_id="+price_list_id+"");
            while(rs.next()){
                int item_no = rs.getInt("item_no");
                int supplier_id = rs.getInt("supplier_id");
                int price_type = rs.getInt("price_type");
                int active = rs.getInt("active");
                rowData[i][0] = rs.getInt("price_id");
                rowData[i][1] = ItemController.getItemNameById(item_no);
                rowData[i][2] = rs.getFloat("price_before_vat");
                rowData[i][3] = rs.getFloat("vat");
                rowData[i][4] = rs.getFloat("price_after_vat");
                rowData[i][5] = SupplierController.getSupplierNameById(supplier_id);
                rowData[i][6] = PriceList.getPriceListNameById(price_list_id);
                if(price_type == 1){
                   rowData[i][7] = "Giá bán";
                }else if(price_type == 2){
                    rowData[i][7] = "Giá mua";
                }else{
                    rowData[i][7] = "Không rõ";
                }
                if(active == 0){
                    rowData[i][8] = "Không";
                }else if(active == 1){
                   rowData[i][8] = "Có";
                }else{
                    rowData[i][8] = "Không rõ";
                }
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
    public static DefaultTableModel getAllCurrentPrice(int price_type){
        Connection conn = DBConnection.getConnection();
        int record_num = PriceController.countPriceRecord();
        Object[][] rowData = new Object[record_num][9];
        Object columnNames[] = {"ID", "Tên hàng hóa", "Giá trước vat", "Vat", "Giá sau vat","Nhà cung cấp", "Bảng giá", "Loại giá", "Hiệu lực" };
        try {
            int i = 0;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from price where price_type=" + price_type+ " and active="+1+"");
            while(rs.next()){
                int price_list_id = rs.getInt("price_list_id");
                int item_no = rs.getInt("item_no");
                int supplier_id = rs.getInt("supplier_id");
//                int price_type = rs.getInt("price_type");
                int active = rs.getInt("active");
                rowData[i][0] = rs.getInt("price_id");
                rowData[i][1] = ItemController.getItemNameById(item_no);
                rowData[i][2] = rs.getFloat("price_before_vat");
                rowData[i][3] = rs.getFloat("vat");
                rowData[i][4] = rs.getFloat("price_after_vat");
                rowData[i][5] = SupplierController.getSupplierNameById(supplier_id);
                rowData[i][6] = PriceList.getPriceListNameById(price_list_id);
                if(price_type == 1){
                    rowData[i][7] = "Giá bán";
                }else if(price_type == 2){
                    rowData[i][7] = "Giá mua";
                }else{
                    rowData[i][7] = "Không rõ";
                }
                if(active == 0){
                    rowData[i][8] = "Không";
                }else if(active == 1){
                    rowData[i][8] = "Có";
                }else{
                    rowData[i][8] = "Không rõ";
                }
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

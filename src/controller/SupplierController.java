package controller;

import com.company.DBConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SupplierController {
    public static boolean createNewSupplier(String supplier_name, String supplier_phone, String supplier_address) {
        Connection conn = DBConnection.getConnection();
        if(supplier_name == "" || supplier_phone == "" || supplier_address == ""){
            return false;
        }
        try {
            Statement st = conn.createStatement();
            int rs = st.executeUpdate("insert into supplier(supplier_name, supplier_phone, supplier_address) values('" + supplier_name + "','" + supplier_phone + "','"+ supplier_address +"')");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static DefaultTableModel getSupplierDataToTable(){
        Connection conn = DBConnection.getConnection();
        int record_num = ItemController.countItemRecord();
        Object[][] rowData = new Object[record_num][4];
        Object columnNames[] = {"ID", "Tên nhà cung cấp", "Điện thoại", "Địa chỉ"};
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
    public static int countSupplierRecord(){
        Connection conn = DBConnection.getConnection();
        int record_num = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(*) from supplier");
            while(rs.next()){
                record_num = rs.getInt("count");
            }
            return record_num;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return record_num;
    }
    public static int getLastSupplierId(){
        Connection conn = DBConnection.getConnection();
        int last_supplier_id = 0;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from supplier");
            while(rs.next()){
                last_supplier_id = rs.getInt("supplier_id");
            }
            return last_supplier_id;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return last_supplier_id;
    }
}

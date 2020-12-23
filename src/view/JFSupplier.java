package view;

import controller.ItemController;
import controller.SupplierController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFSupplier {
    public static void viewSupplierView() {
        JFrame frame = new JFrame("Quản lý nhà cung cấp");
        frame.setSize(800, 700);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel supplierNameLabel = new JLabel("Tên nhà cung cấp");
        supplierNameLabel.setBounds(10,20,200,25);
        panel.add(supplierNameLabel);

        JTextField supplierNameText = new JTextField("");
        supplierNameText.setBounds(150, 20, 600, 25);
        panel.add(supplierNameText);

        JLabel supplierPhoneLabel = new JLabel("Số điện thoại");
        supplierPhoneLabel.setBounds(10,50,200,25);
        panel.add(supplierPhoneLabel);

        JTextField supplierPhoneText = new JTextField("");
        supplierPhoneText.setBounds(150, 50, 600, 25);
        panel.add(supplierPhoneText);

        JLabel supplierAddressLabel = new JLabel("Địa chỉ");
        supplierAddressLabel.setBounds(10,80,80,25);
        panel.add(supplierAddressLabel);

        JTextField supplierAddressText = new JTextField("");
        supplierAddressText.setBounds(150, 80, 600, 25);
        panel.add(supplierAddressText);

        JButton addButton = new JButton("Thêm nhà cung cấp");
        addButton.setBounds(300, 110, 200, 30);
        panel.add(addButton);

        JTable table = new JTable(SupplierController.getSupplierDataToTable());
        table.setBounds(0,0,500,300);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,200,550,350);
        panel.add(sp);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int supplier_id = SupplierController.getLastSupplierId() + 1;
                String supplier_name = supplierNameText.getText();
                String supplier_phone = supplierPhoneText.getText();
                String supplier_address = supplierAddressText.getText();
                boolean inserted = SupplierController.createNewSupplier(supplier_name,supplier_phone,supplier_address);
                if(inserted){
                    JOptionPane.showMessageDialog(panel,"Thêm mới nhà cung cấp thành công");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{
                            supplier_id,
                            supplier_name,
                            supplier_phone,
                            supplier_address
                    });
                }else{
                    JOptionPane.showMessageDialog(panel,"Thêm mới nhà cung cấp thất bại");
                }
            }
        });
    }
}

package view;
import controller.ItemController;
import model.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFItem {
    public static void viewItem() {
        JFrame frame = new JFrame("Quản lý hàng hóa");
        frame.setSize(800, 700);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    public JFItem() {
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel itemNameLabel = new JLabel("Tên hàng hóa");
        itemNameLabel.setBounds(10,20,200,25);
        panel.add(itemNameLabel);

        JTextField itemNameText = new JTextField("");
        itemNameText.setBounds(150, 20, 600, 25);
        panel.add(itemNameText);

        JLabel itemBarcodeLabel = new JLabel("Mã vạch");
        itemBarcodeLabel.setBounds(10,50,80,25);
        panel.add(itemBarcodeLabel);

        JTextField itemBarcodeText = new JTextField("");
        itemBarcodeText.setBounds(150, 50, 600, 25);
        panel.add(itemBarcodeText);

        JButton addButton = new JButton("Thêm hàng hóa");
        addButton.setBounds(300, 80, 200, 30);
        panel.add(addButton);

        JTable table = new JTable(ItemController.getItemDataToTable());
        table.setBounds(0,0,500,300);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,200,550,350);
        panel.add(sp);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item_no = ItemController.getLastItemId() + 1;
                String itemName = itemNameText.getText();
                String itemBarcode = itemBarcodeText.getText();
                boolean inserted = ItemController.createNewItem(itemName,itemBarcode);
                if(inserted){
                    JOptionPane.showMessageDialog(panel,"Thêm mới hàng hóa thành công");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{
                           item_no,
                           itemName,
                           itemBarcode
                    });
                }else{
                    JOptionPane.showMessageDialog(panel,"Thêm mới hàng hóa thất bại");
                }
            }
        });
    }
}
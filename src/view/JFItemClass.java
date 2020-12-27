package view;

import controller.ItemClassController;
import controller.ItemController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFItemClass {
    public static void viewItemClass() {
        JFrame frame = new JFrame("Quản lý nhóm hàng hóa");
        frame.setSize(800, 700);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    public JFItemClass() {
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel itemClassNameLabel = new JLabel("Tên nhóm hàng hóa");
        itemClassNameLabel.setBounds(10,20,200,25);
        panel.add(itemClassNameLabel);

        JTextField itemClassNameText = new JTextField("");
        itemClassNameText.setBounds(150, 20, 600, 25);
        panel.add(itemClassNameText);

        JButton addButton = new JButton("Thêm nhóm hàng hóa");
        addButton.setBounds(300, 80, 200, 30);
        panel.add(addButton);

        JTable table = new JTable(ItemClassController.getItemClassDataToTable());
        table.setBounds(0,0,500,300);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,200,550,350);
        panel.add(sp);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int item_class_id = ItemClassController.getLastItemClassId() + 1;
                String itemClassName = itemClassNameText.getText();
                boolean inserted = ItemClassController.createNewItemClass(itemClassName);
                if(inserted){
                    JOptionPane.showMessageDialog(panel,"Thêm mới nhóm hàng hóa thành công");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{
                            item_class_id,
                            itemClassName
                    });
                }else{
                    JOptionPane.showMessageDialog(panel,"Thêm mới nhóm hàng hóa thất bại");
                }
            }
        });
    }
}

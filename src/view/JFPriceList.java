package view;

import controller.ItemController;
import controller.PriceList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JFPriceList {
    public static void viewPriceList() {
        JFrame frame = new JFrame("Quản lý bảng giá");
        frame.setSize(800, 700);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel priceListNameLabel= new JLabel("Tên bảng giá");
        priceListNameLabel.setBounds(10,20,200,25);
        panel.add(priceListNameLabel);

        JTextField priceListNameText = new JTextField("");
        priceListNameText.setBounds(150, 20, 600, 25);
        panel.add(priceListNameText);

        JButton addPriceListButton = new JButton("Thêm bảng giá");
        addPriceListButton.setBounds(300,50, 200, 30);
        panel.add(addPriceListButton);


        JTable table = new JTable(PriceList.getPriceListDataToTable());
        table.setBounds(0,0,500,300);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,200,550,350);
        panel.add(sp);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 DefaultTableModel tblmodel = (DefaultTableModel)table.getModel();
                 String price_list_id = tblmodel.getValueAt(table.getSelectedRow(), 0).toString();
                 System.out.println("Id Pricelist " + price_list_id);
                 JFPrice jfPrice = new JFPrice();
                 jfPrice.viewPrice(price_list_id);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addPriceListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String price_list_name = priceListNameText.getText();
                boolean price_list_name_existed = PriceList.checkPriceListNameDuplication(price_list_name);
                int last_price_list_id = PriceList.getLastPriceListId();
                if(price_list_name == ""){
                    JOptionPane.showMessageDialog(panel,"Không được bỏ trống tên bảng giá");
                }else if(price_list_name_existed == true){
                    JOptionPane.showMessageDialog(panel,"Tên bảng gía này đã tồn tại");
                }else{
                    PriceList.addPriceList(price_list_name);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{
                       last_price_list_id + 1,
                       price_list_name
                    });
                }
            }
        });
    }
}

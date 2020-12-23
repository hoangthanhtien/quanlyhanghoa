package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFHome {
    public static void JFHomeView(){
        JFrame frame = new JFrame("Chọn chức năng");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

//        Quan ly item
        JButton itemButton = new JButton("Hàng hóa");
        itemButton.setBounds(20, 30, 360, 30);
        panel.add(itemButton);
        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFItem jfItem = new JFItem();
                jfItem.viewItem();
            }
        });
//        Quan ly gia
        JButton priceListButton = new JButton("Bảng giá");
        priceListButton.setBounds(20, 70, 360, 30);
        panel.add(priceListButton);
        priceListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFPriceList jfPriceList = new JFPriceList();
                jfPriceList.viewPriceList();
            }
        });
//        Quan ly item_class
//        Quan ly nha cung cap
        JButton supplierButton = new JButton("Nhà cung cấp");
        supplierButton.setBounds(20, 120, 360, 30);
        panel.add(supplierButton);
        supplierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFSupplier jfSupplier = new JFSupplier();
                jfSupplier.viewSupplierView();
            }
        });
    }
}

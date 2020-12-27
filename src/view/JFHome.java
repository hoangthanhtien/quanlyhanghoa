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
        JButton priceListButton = new JButton("Cài đặt bảng giá");
        priceListButton.setBounds(20, 70, 360, 30);
        panel.add(priceListButton);
        priceListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFPriceList jfPriceList = new JFPriceList();
                jfPriceList.viewPriceList();
            }
        });

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
//        Quan ly item_class
        JButton itemClassButton = new JButton("Nhóm hàng hóa");
        itemClassButton.setBounds(20, 170 , 360, 30);
        panel.add(itemClassButton);
        itemClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFItemClass jfItemClass = new JFItemClass();
                jfItemClass.viewItemClass();
            }
        });
//        Bang gia ban hien hanh
        JButton itemCurrentSalePriceButton = new JButton("Bảng giá bán hiện hành");
        itemCurrentSalePriceButton.setBounds(20, 220 , 360, 30);
        panel.add(itemCurrentSalePriceButton);
        itemCurrentSalePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFCurrentPrice jfCurrentPrice = new JFCurrentPrice();
                jfCurrentPrice.viewCurrentPrice(1);
            }
        });
//
        JButton itemCurrentPurchasePriceButton = new JButton("Bảng giá mua hiện hành");
        itemCurrentPurchasePriceButton.setBounds(20, 270 , 360, 30);
        panel.add(itemCurrentPurchasePriceButton);
        itemCurrentPurchasePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFCurrentPrice jfCurrentPrice = new JFCurrentPrice();
                jfCurrentPrice.viewCurrentPrice(2);
            }
        });
    }
}

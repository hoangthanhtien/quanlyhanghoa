package view;

import controller.ItemClassController;
import controller.PriceController;

import javax.swing.*;

public class JFCurrentPrice {

    public static void viewCurrentPrice(int price_type) {
        JFrame frame = new JFrame("Danh sách giá hiện hành");
        frame.setSize(800, 700);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, price_type);
        frame.setVisible(true);
    }

    public JFCurrentPrice() {
    }

    private static void placeComponents(JPanel panel, int price_type) {
        panel.setLayout(null);
        JTable table = new JTable(PriceController.getAllCurrentPrice(price_type));
        table.setBounds(0,0,500,300);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,200,550,350);
        panel.add(sp);
    }
}

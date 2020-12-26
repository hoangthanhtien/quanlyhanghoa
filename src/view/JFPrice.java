package view;

import controller.ItemController;
import controller.PriceController;
import controller.PriceList;
import controller.SupplierController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.FileLock;

public class JFPrice {
    public static void viewPrice(String price_list_id) {
        JFrame frame = new JFrame("Quản lý giá");
        frame.setSize(800, 700);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, price_list_id);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel, String price_list_id) {

        panel.setLayout(null);
        JLabel priceBFVatLabel= new JLabel("Giá trước vat");
        priceBFVatLabel.setBounds(10,20,200,25);
        panel.add(priceBFVatLabel);

        JTextField priceBFVatText= new JTextField("");
        priceBFVatText.setBounds(150, 20, 600, 25);
        panel.add(priceBFVatText);

        JLabel vatLabel = new JLabel("Thuế vat");
        vatLabel.setBounds(10,50,200,25);
        panel.add(vatLabel);

        JTextField vatText = new JTextField("");
        vatText.setBounds(150, 50, 600, 25);
        panel.add(vatText);

        JLabel itemNoLabel= new JLabel("ID hàng hóa");
        itemNoLabel.setBounds(10,80,200,25);
        panel.add(itemNoLabel);

        JTextField itemNoText= new JTextField("");
        itemNoText.setBounds(150, 80, 600, 25);
        panel.add(itemNoText);

        JLabel supplierIdLabel= new JLabel("ID nhà cung cấp");
        supplierIdLabel.setBounds(10,110,200,25);
        panel.add(supplierIdLabel);

        JTextField supplierIdText = new JTextField("");
        supplierIdText.setBounds(150, 110, 600, 25);
        panel.add(supplierIdText);

        JLabel priceTypeLabel = new JLabel("Loại giá");
        priceTypeLabel.setBounds(10,150,200,25);
        panel.add(priceTypeLabel);

        JRadioButton giaBanButton = new JRadioButton("Giá bán");
        giaBanButton.setBounds(150, 150, 100, 30);
        panel.add(giaBanButton);

        JRadioButton giaMuaButton = new JRadioButton("Giá mua");
        giaMuaButton.setBounds(250, 150, 100, 30);
        panel.add(giaMuaButton);

        ButtonGroup priceTypeButtonGroup = new ButtonGroup();
        priceTypeButtonGroup.add(giaBanButton);
        priceTypeButtonGroup.add(giaMuaButton);

        JLabel activeLabel = new JLabel("Hiệu lực");
        activeLabel.setBounds(10,180,200,25);
        panel.add(activeLabel);

        JRadioButton activeButton = new JRadioButton("Có");
        activeButton.setBounds(150, 180, 100, 30);
        panel.add(activeButton);

        JRadioButton deActiveButton = new JRadioButton("Không");
        deActiveButton.setBounds(250, 180, 100, 30);
        panel.add(deActiveButton);

        ButtonGroup activeButtonGroup = new ButtonGroup();
        activeButtonGroup.add(activeButton);
        activeButtonGroup.add(deActiveButton);

        JButton addPriceButton = new JButton("Thêm giá");
        addPriceButton.setBounds(300,210, 200, 30);
        panel.add(addPriceButton);

        JTable table = new JTable(PriceController.getPriceDataToTable(Integer.parseInt(price_list_id)));
        table.setBounds(0,0,500,300);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(150,250,550,350);
        panel.add(sp);

        addPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int price_type = 0;
                String price_type_string = "";
                if(giaBanButton.isSelected()){
                    price_type = 1;
                    price_type_string = "Giá bán";
                }else if(giaMuaButton.isSelected()){
                    price_type = 2;
                    price_type_string = "Giá mua";
                }else{
                    JOptionPane.showMessageDialog(panel,"Bạn phải chọn loại giá mua hoặc bán");
                }
                int active;
                String active_string = "";
                if(deActiveButton.isSelected()){
                    active = 0;
                    active_string = "Không";
                }else{
                    active = 1;
                    active_string = "Có";
                }
                float price_before_vat = Float.parseFloat(priceBFVatText.getText());
                float vat = Float.parseFloat(vatText.getText());
                float price_after_vat = price_before_vat + (price_before_vat * (vat/100));
                int item_no = Integer.parseInt(itemNoText.getText());
                int supplier_id = Integer.parseInt(supplierIdText.getText());
                int priceListId = Integer.parseInt(price_list_id);
                boolean createNewPrice = PriceController.createNewPrice(price_type, price_before_vat, vat, price_after_vat, item_no, active, supplier_id, priceListId);
                if(createNewPrice == true){
                    JOptionPane.showMessageDialog(panel,"Thêm giá mới thành công");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{
                            PriceController.getLastPriceId(),
                            ItemController.getItemNameById(item_no),
                            price_before_vat,
                            vat,
                            price_after_vat,
                            SupplierController.getSupplierNameById(supplier_id),
                            PriceList.getPriceListNameById(priceListId),
                            price_type_string,
                            active_string
                    });
                }else{
                    JOptionPane.showMessageDialog(panel, "Thêm giá mới thất bại :((");
                }
            }
        });
    }
}

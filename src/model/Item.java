package model;

public class Item {
    private String item_no;
    private String item_name;
    private ItemClass item_class;
    private String barcode;

    public Item() {
    }

    public Item(String item_no, String item_name, ItemClass item_class, String barcode) {
        this.item_no = item_no;
        this.item_name = item_name;
        this.item_class = item_class;
        this.barcode = barcode;
    }

    public String getItem_no() {
        return item_no;
    }

    public String getItem_name() {
        return item_name;
    }

    public ItemClass getItem_class() {
        return item_class;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_class(ItemClass item_class) {
        this.item_class = item_class;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

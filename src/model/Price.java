package model;

public class Price {
    private int price_type; // 1 = giaban, 2 = giamua, 3 = giavon
    private float price_before_vat;
    private float vat; // Theo %
    private float price_after_vat;
    private int item_no;
    private int price_id;
    private int active; // 0.deactive 1.active
    private int supplier_id;
    private int price_list_id;

    public Price() {
    }

    public Price(int price_type, float price_before_vat, float vat, float price_after_vat, int item_no, int price_id, int active, int supplier_id, int price_list_id) {
        this.price_type = price_type;
        this.price_before_vat = price_before_vat;
        this.vat = vat;
        this.price_after_vat = price_after_vat;
        this.item_no = item_no;
        this.price_id = price_id;
        this.active = active;
        this.supplier_id = supplier_id;
        this.price_list_id = price_list_id;
    }

    public int getPrice_type() {
        return price_type;
    }

    public float getPrice_before_vat() {
        return price_before_vat;
    }

    public float getVat() {
        return vat;
    }

    public float getPrice_after_vat() {
        return price_after_vat;
    }

    public int getItem_no() {
        return item_no;
    }

    public int getPrice_id() {
        return price_id;
    }

    public int getActive() {
        return active;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public int getPrice_list_id() {
        return price_list_id;
    }

    public void setPrice_type(int price_type) {
        this.price_type = price_type;
    }

    public void setPrice_before_vat(float price_before_vat) {
        this.price_before_vat = price_before_vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public void setPrice_after_vat(float price_after_vat) {
        this.price_after_vat = price_after_vat;
    }

    public void setItem_no(int item_no) {
        this.item_no = item_no;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public void setPrice_list_id(int price_list_id) {
        this.price_list_id = price_list_id;
    }
}

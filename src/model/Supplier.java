package model;

public class Supplier {
    private int supplier_id;
    private String supplier_name;
    private String supplier_phone;
    private String supplier_address;

    public Supplier() {
    }

    public Supplier(int supplier_id, String supplier_name, String supplier_phone, String supplier_address) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.supplier_phone = supplier_phone;
        this.supplier_address = supplier_address;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public String getSupplier_phone() {
        return supplier_phone;
    }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public void setSupplier_phone(String supplier_phone) {
        this.supplier_phone = supplier_phone;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }
}

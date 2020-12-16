package model;

public class Price {
    private int price_type; // 1 = giaban, 2 = giamua, 3 = giavon
    private int price_before_vat;
    private int vat; // Theo %
    private int price_after_vat;
    private Item item;
    private PriceList priceList;
    private int active;
    private int created_at;
    private Supplier supplier;

    public Price() {
    }

    public Price(int price_type, int price_before_vat, int vat, int price_after_vat, Item item, PriceList priceList, int active, int created_at, Supplier supplier) {
        this.price_type = price_type;
        this.price_before_vat = price_before_vat;
        this.vat = vat;
        this.price_after_vat = price_after_vat;
        this.item = item;
        this.priceList = priceList;
        this.active = active;
        this.created_at = created_at;
        this.supplier = supplier;
    }

    public int getPrice_type() {
        return price_type;
    }

    public int getPrice_before_vat() {
        return price_before_vat;
    }

    public int getVat() {
        return vat;
    }

    public int getPrice_after_vat() {
        return price_after_vat;
    }

    public Item getItem() {
        return item;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public int getActive() {
        return active;
    }

    public int getCreated_at() {
        return created_at;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setPrice_type(int price_type) {
        this.price_type = price_type;
    }

    public void setPrice_before_vat(int price_before_vat) {
        this.price_before_vat = price_before_vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setPrice_after_vat(int price_after_vat) {
        this.price_after_vat = price_after_vat;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}

package model;

public class PriceList {
    private String price_list_id;
    private String price_list_name;
    private int active; // 0.deactive 1.active

    public PriceList() {
    }

    public PriceList(String price_list_id, String price_list_name, int active) {
        this.price_list_id = price_list_id;
        this.price_list_name = price_list_name;
        this.active = active;
    }

    public String getPrice_list_id() {
        return price_list_id;
    }

    public String getPrice_list_name() {
        return price_list_name;
    }

    public int getActive() {
        return active;
    }

    public void setPrice_list_id(String price_list_id) {
        this.price_list_id = price_list_id;
    }

    public void setPrice_list_name(String price_list_name) {
        this.price_list_name = price_list_name;
    }

    public void setActive(int active) {
        this.active = active;
    }
}

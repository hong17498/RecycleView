package vn.edu.ntu.thuyhong.model;

public class Product {
    String name;
    int Price;
    String desc;

    public Product(String name, int price, String desc) {
        this.name = name;
        Price = price;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

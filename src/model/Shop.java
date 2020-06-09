package model;

public class Shop {
    private int id;
    private  String url;
    private String name;
    private String price;
    private String Description;

    public Shop(String url,String name, String price, String description) {
        this.url=url;
        this.name = name;
        this.price = price;
        this.Description = description;
    }

    public Shop(int id,String url, String name, String price, String description) {
        this.id = id;
        this.url=url;
        this.name = name;
        this.price = price;
        this.Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

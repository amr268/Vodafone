package com.task.bundles.data.models.bundle;

public class BundleModel {

    private String title;
    private String price;
    private String currency;
    private String type;
    private String description;

    public BundleModel(String title, String price, String currency, String type, String description) {
        this.title = title;
        this.price = price;
        this.currency = currency;
        this.type = type;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}

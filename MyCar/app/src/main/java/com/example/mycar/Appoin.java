package com.example.mycar;

public class Appoin {
    String date;
    String immat;
    String shop;
    String type;
    String owner;

    public Appoin() {
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public Appoin(String date, String immat, String shop, String type, String owner) {
        this.date = date;
        this.immat = immat;
        this.shop = shop;
        this.type = type;
        this.owner = owner;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public String getImmat() {
        return immat;
    }

    public String getShop() {
        return shop;
    }

    public String getType() {
        return type;
    }
}

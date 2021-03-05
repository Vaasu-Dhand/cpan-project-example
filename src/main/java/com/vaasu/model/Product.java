package com.vaasu.model;

public abstract class Product {
    private String name;
    private int price;
    private int quantityInStore;
    private String producerCompany;

    public Product(String name, int price, int quantityInStore, String producerCompany) {
        this.name = name;
        this.price = price;
        this.quantityInStore = quantityInStore;
        this.producerCompany = producerCompany;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityInStore() {
        return quantityInStore;
    }

    public void setQuantityInStore(int quantityInStore) {
        this.quantityInStore = quantityInStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducerCompany() {
        return producerCompany;
    }

    public void setProducerCompany(String producerCompany) {
        this.producerCompany = producerCompany;
    }
}

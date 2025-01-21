package com.insy2s.exercices.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger atomicInteger = new AtomicInteger(-1);
    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

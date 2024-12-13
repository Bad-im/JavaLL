package com.mkyong.examples.Chapter4.VarantB.FlowerShop.model;

public abstract class Flower {
    private String name;
    private double price;
    private int freshnessLevel;
    private double stemLength;

    public Flower(String name, double price, int freshnessLevel, double stemLength) {
        this.name = name;
        this.price = price;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public double getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return name + " (Цена: " + price + ", Свежесть: " + freshnessLevel + ", Длина стебля: " + stemLength + ")";
    }
}
package com.mkyong.examples.Chapter10.VariantB;

import java.io.Serializable;

abstract class Flower implements Serializable {
    private String name;
    private double price;
    private int freshness; // 1 - свежий, 2 - чуть увядший, 3 - увядший

    public Flower(String name, double price, int freshness) {
        this.name = name;
        this.price = price;
        this.freshness = freshness;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    @Override
    public String toString() {
        return name + " (Цена: " + price + ", Свежесть: " + freshness + ")";
    }
}

class Rose extends Flower {
    public Rose(double price, int freshness) {
        super("Роза", price, freshness);
    }
}

class Tulip extends Flower {
    public Tulip(double price, int freshness) {
        super("Тюльпан", price, freshness);
    }
}

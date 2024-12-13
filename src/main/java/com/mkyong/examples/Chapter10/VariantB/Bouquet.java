package com.mkyong.examples.Chapter10.VariantB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Bouquet implements Serializable {
    private List<Flower> flowers = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Flower flower : flowers) {
            total += flower.getPrice();
        }
        return total;
    }

    public void sortFlowersByFreshness() {
        Collections.sort(flowers, Comparator.comparingInt(Flower::getFreshness));
    }

    public List<Flower> findFlowersByStemLength(int minLength, int maxLength) {
        return flowers;
    }

    @Override
    public String toString() {
        return "Букет: " + flowers.toString();
    }
}

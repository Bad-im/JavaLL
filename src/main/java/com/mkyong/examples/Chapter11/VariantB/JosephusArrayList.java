package com.mkyong.examples.Chapter11.VariantB;

import java.util.ArrayList;
import java.util.List;

public class JosephusArrayList {
    public static void main(String[] args) {
        int n = 7;
        List<Integer> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }

        System.out.println("Последний оставшийся человек: " + people.get(0));
    }
}

package com.mkyong.examples.Chapter11.VariantB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Josephus {
    public static int josephusArrayList(int n) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }

    public static int josephusLinkedList(int n) {
        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        return people.get(0);
    }
}

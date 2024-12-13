package com.mkyong.examples.Chapter11.VariantB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTest {
    public static void main(String[] args) {
        int n = 100000; // Увеличьте это значение для более тщательного тестирования

        // Test ArrayList
        long startTime = System.nanoTime();
        josephusArrayList(n);
        long endTime = System.nanoTime();
        System.out.println("ArrayList время выполнения: " + (endTime - startTime) + " нс");

        // Test LinkedList
        startTime = System.nanoTime();
        josephusLinkedList(n);
        endTime = System.nanoTime();
        System.out.println("LinkedList время выполнения: " + (endTime - startTime) + " нс");
    }

    private static void josephusArrayList(int n) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
    }

    private static void josephusLinkedList(int n) {
        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
    }
}

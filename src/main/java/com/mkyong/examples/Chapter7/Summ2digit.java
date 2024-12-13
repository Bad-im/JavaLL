package com.mkyong.examples.Chapter7;

import java.util.function.Function;

public class Summ2digit {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> add = a -> b -> a + b;

        int sum = add.apply(5).apply(3);
        System.out.println("Сумма: " + sum);
    }
}

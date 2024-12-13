package com.mkyong.examples.Chapter7;

import java.util.function.Function;

public class SplitString {
    public static void main(String[] args) {
        Function<String, Function<String, String[]>> split = regex -> str -> str.split(regex);

        String[] parts = split.apply(",").apply("apple,banana,cherry");
        System.out.println("Разбитая строка:");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}

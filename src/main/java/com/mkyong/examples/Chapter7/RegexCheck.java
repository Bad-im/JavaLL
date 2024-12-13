package com.mkyong.examples.Chapter7;

import java.util.function.Function;

public class RegexCheck {
    public static void main(String[] args) {
        Function<String, Function<String, Boolean>> matches = regex -> str -> str.matches(regex);

        boolean isMatch = matches.apply("\\d+").apply("12345");
        System.out.println("Строка соответствует регулярному выражению: " + isMatch);
    }
}

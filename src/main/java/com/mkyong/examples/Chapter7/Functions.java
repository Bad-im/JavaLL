package com.mkyong.examples.Chapter7;

import java.util.function.Function;

public class Functions {

    public static Function<Integer, Function<Integer, Integer>> add = a -> b -> a + b;

    public static Function<String, Function<String, Boolean>> matches = regex -> str -> str.matches(regex);

    public static Function<String, Function<String, String[]>> split = regex -> str -> str.split(regex);
}

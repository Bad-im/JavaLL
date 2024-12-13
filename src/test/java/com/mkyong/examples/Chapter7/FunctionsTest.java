package com.mkyong.examples.Chapter7;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @Test
    void testAddFunction() {
        Function<Integer, Function<Integer, Integer>> add = Functions.add;
        int sum = add.apply(5).apply(3);
        assertEquals(8, sum);
    }

    @Test
    void testMatchesFunction() {
        Function<String, Function<String, Boolean>> matches = Functions.matches;
        boolean isMatch = matches.apply("\\d+").apply("12345");
        assertTrue(isMatch);

        boolean isNotMatch = matches.apply("\\d+").apply("abc");
        assertFalse(isNotMatch);
    }

    @Test
    void testSplitFunction() {
        Function<String, Function<String, String[]>> split = Functions.split;
        String[] parts = split.apply(",").apply("apple,banana,cherry");

        assertArrayEquals(new String[]{"apple", "banana", "cherry"}, parts);
    }
}

package com.mkyong.examples.Chapter8.VariantA;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VariantATest {

    @Test
    void testReplaceKthCharacter() {
        String result1 = VariantA.replaceKthCharacter("hello", 1, 'H');
        assertEquals("Hello", result1);

        String result2 = VariantA.replaceKthCharacter("hello", 2, 'a');
        assertEquals("hallo", result2);

        String result3 = VariantA.replaceKthCharacter("hello", 3, 'l');
        assertEquals("hello", result3);

        String result4 = VariantA.replaceKthCharacter("hello", 6, 'x');
        assertEquals("hello", result4);

        String result5 = VariantA.replaceKthCharacter("", 1, 'x');
        assertEquals("", result5);
    }
}

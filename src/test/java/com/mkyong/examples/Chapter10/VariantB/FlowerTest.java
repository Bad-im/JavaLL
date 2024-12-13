package com.mkyong.examples.Chapter10.VariantB;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {

    @Test
    void testFlowerCreation() {
        Flower rose = new Rose(10.0, 1);
        assertEquals("Роза", rose.getName());
        assertEquals(10.0, rose.getPrice());
        assertEquals(1, rose.getFreshness());
    }

    @Test
    void testTulipCreation() {
        Flower tulip = new Tulip(8.0, 2);
        assertEquals("Тюльпан", tulip.getName());
        assertEquals(8.0, tulip.getPrice());
        assertEquals(2, tulip.getFreshness());
    }
}

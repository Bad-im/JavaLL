package com.mkyong.examples.Chapter10.VariantB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class BouquetTest {

    private Bouquet bouquet;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        bouquet.addFlower(new Rose(10.0, 1));
        bouquet.addFlower(new Tulip(8.0, 2));
        bouquet.addFlower(new Rose(12.0, 3));
    }

    @Test
    void testCalculateTotalPrice() {
        assertEquals(30.0, bouquet.calculateTotalPrice());
    }

    @Test
    void testSortFlowersByFreshness() {
        bouquet.sortFlowersByFreshness();
        List<Flower> flowers = bouquet.findFlowersByStemLength(0, 0); // Здесь просто получаем все цветы

        assertEquals("Роза", flowers.get(0).getName());
        assertEquals("Тюльпан", flowers.get(1).getName());
        assertEquals("Роза", flowers.get(2).getName());
    }

    @Test
    void testAddFlower() {
        Flower newFlower = new Tulip(9.0, 1);
        bouquet.addFlower(newFlower);
        assertEquals(4, bouquet.findFlowersByStemLength(0, 0).size()); // Проверяем, что цветок добавился
    }
}

package com.mkyong.examples.Chapter10.VariantB;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class BouquetConnectorTest {

    private BouquetConnector connector;
    private Bouquet bouquet;
    private final String filename = "test_bouquet.dat";

    @BeforeEach
    void setUp() {
        connector = new BouquetConnector();
        bouquet = new Bouquet();
        bouquet.addFlower(new Rose(10.0, 1));
        bouquet.addFlower(new Tulip(8.0, 2));
    }

    @AfterEach
    void tearDown() {
        // Удаляем файл после теста
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSerializeBouquet() {
        connector.serializeBouquet(bouquet, filename);
        File file = new File(filename);
        assertTrue(file.exists()); // Проверяем, что файл был создан
    }

    @Test
    void testDeserializeBouquet() {
        connector.serializeBouquet(bouquet, filename);
        Bouquet deserializedBouquet = connector.deserializeBouquet(filename);
        assertNotNull(deserializedBouquet); // Проверяем, что десериализация прошла успешно
        assertEquals(2, deserializedBouquet.findFlowersByStemLength(0, 0).size()); // Проверяем количество цветов
    }
}

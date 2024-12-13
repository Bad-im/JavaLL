package com.mkyong.examples.Chapter10.VariantC;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberFileSorterTest {
    private static final String TEST_DIRECTORY = "test_output";
    private static final String TEST_FILE = TEST_DIRECTORY + File.separator + "test_random_numbers.txt";

    @BeforeEach
    void setUp() {
        RandomNumberFileSorter.createDirectory(TEST_DIRECTORY);
    }

    @AfterEach
    void tearDown() {
        // Удаляем тестовую директорию и файл после тестов
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE));
            Files.deleteIfExists(Paths.get(TEST_DIRECTORY));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCreateDirectory() {
        File dir = new File(TEST_DIRECTORY);
        assertTrue(dir.exists(), "Директория должна существовать после создания.");
    }

    @Test
    void testGenerateRandomNumbers() {
        List<Integer> numbers = RandomNumberFileSorter.generateRandomNumbers(10);
        assertEquals(10, numbers.size(), "Должно быть сгенерировано 10 случайных чисел.");
    }

    @Test
    void testWriteAndReadNumbersToFile() {
        List<Integer> numbers = List.of(5, 3, 8, 1, 2);
        RandomNumberFileSorter.writeNumbersToFile(numbers, TEST_FILE);

        List<Integer> readNumbers = RandomNumberFileSorter.readNumbersFromFile(TEST_FILE);
        assertEquals(numbers.size(), readNumbers.size(), "Количество считанных чисел должно совпадать.");
        assertIterableEquals(numbers, readNumbers, "Считанные числа должны совпадать с записанными.");
    }

    @Test
    void testSortNumbersInFile() {
        List<Integer> numbers = List.of(5, 3, 8, 1, 2);
        RandomNumberFileSorter.writeNumbersToFile(numbers, TEST_FILE);

        List<Integer> sortedNumbers = RandomNumberFileSorter.readNumbersFromFile(TEST_FILE);
        sortedNumbers.sort(Integer::compareTo);
        RandomNumberFileSorter.writeNumbersToFile(sortedNumbers, TEST_FILE);

        List<Integer> finalNumbers = RandomNumberFileSorter.readNumbersFromFile(TEST_FILE);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, finalNumbers.toArray(), "Числа должны быть отсортированы.");
    }
}

package com.mkyong.examples.Chapter9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloatingPointNumbersProcessorTest {

    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = File.createTempFile("test_numbers", ".txt");
    }

    @AfterEach
    void tearDown() {
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void testCalculateSum() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0);
        double sum = FloatingPointNumbersProcessor.calculateSum(numbers);
        assertEquals(6.0, sum);
    }

    @Test
    void testCalculateAverage() {
        List<Double> numbers = Arrays.asList(1.0, 2.0, 3.0);
        double average = FloatingPointNumbersProcessor.calculateAverage(numbers);
        assertEquals(2.0, average);
    }

    @Test
    void testCalculateAverageEmptyList() {
        List<Double> numbers = Arrays.asList();
        double average = FloatingPointNumbersProcessor.calculateAverage(numbers);
        assertEquals(0.0, average);
    }

    @Test
    void testReadNumbersFromFileValid() throws IOException, InvalidNumberFormatException, CustomMemoryException {
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("1.0\n2.0\n3.0\n");
        }

        List<Double> numbers = FloatingPointNumbersProcessor.readNumbersFromFile(tempFile.getAbsolutePath());
        assertEquals(3, numbers.size());
        assertEquals(1.0, numbers.get(0));
        assertEquals(2.0, numbers.get(1));
        assertEquals(3.0, numbers.get(2));
    }
}

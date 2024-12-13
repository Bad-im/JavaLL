package com.mkyong.examples.Chapter9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FloatingPointNumbersProcessor {

    public static void main(String[] args) {
        String filePath = "numbers.txt";

        List<Double> numbers = new ArrayList<>();

        try {
            numbers = readNumbersFromFile(filePath);
            double sum = calculateSum(numbers);
            double average = calculateAverage(numbers);
            System.out.printf("Сумма: %.2f, Среднее: %.2f%n", sum, average);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (InvalidNumberFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (CustomMemoryException e) {
            System.err.println("Ошибка памяти: " + e.getMessage());
        }
    }

    public static List<Double> readNumbersFromFile(String filePath) throws IOException, InvalidNumberFormatException, CustomMemoryException {
        List<Double> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    double number = parseNumber(line);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    throw new InvalidNumberFormatException("Некорректный формат числа: " + line);
                } catch (OutOfMemoryError e) {
                    throw new CustomMemoryException("Недостаточно памяти для обработки чисел.");
                }
            }
        }

        return numbers;
    }

    public static double parseNumber(String line) {
        return Double.parseDouble(line.trim());
    }

    public static double calculateSum(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static double calculateAverage(List<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return calculateSum(numbers) / numbers.size();
    }
}

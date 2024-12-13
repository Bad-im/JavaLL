package com.mkyong.examples.Chapter10.VariantC;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RandomNumberFileSorter {
    private static final String DIRECTORY_NAME = "output";
    private static final String FILE_NAME = "random_numbers.txt";

    public static void main(String[] args) {
        // Создаем директорию
        createDirectory(DIRECTORY_NAME);

        // Создаем файл и заполняем его случайными числами
        List<Integer> randomNumbers = generateRandomNumbers(10); // Генерируем 10 случайных чисел
        writeNumbersToFile(randomNumbers, DIRECTORY_NAME + File.separator + FILE_NAME);

        // Сортируем числа и записываем обратно в файл
        List<Integer> sortedNumbers = readNumbersFromFile(DIRECTORY_NAME + File.separator + FILE_NAME);
        Collections.sort(sortedNumbers);
        writeNumbersToFile(sortedNumbers, DIRECTORY_NAME + File.separator + FILE_NAME);

        System.out.println("Содержимое файла отсортировано и записано обратно в файл.");
    }

    public static void createDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Директория '" + directoryName + "' была создана.");
        } else {
            System.out.println("Директория '" + directoryName + "' уже существует.");
        }
    }

    public static List<Integer> generateRandomNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(1000)); // Генерируем случайные числа от 0 до 999
        }
        return numbers;
    }

    public static void writeNumbersToFile(List<Integer> numbers, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Integer number : numbers) {
                writer.write(number.toString());
                writer.newLine();
            }
            System.out.println("Случайные числа записаны в файл '" + filePath + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> readNumbersFromFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }
}

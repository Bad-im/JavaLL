package com.mkyong.examples.Chapter10.VariantA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RemoveSubstringFromPoem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputFilePath = "C:\\Users\\vadim\\IdeaProjects\\JavaLL\\A.txt";
        String outputFilePath = "C:\\Users\\vadim\\IdeaProjects\\JavaLL\\B.txt";

        System.out.print("Введите путь к файлу со стихотворением (или нажмите Enter для использования " + inputFilePath + "): ");
        String userInputPath = scanner.nextLine();
        if (!userInputPath.isEmpty()) {
            inputFilePath = userInputPath;
        }

        System.out.print("Введите путь к файлу для записи результата (или нажмите Enter для использования " + outputFilePath + "): ");
        String userOutputPath = scanner.nextLine();
        if (!userOutputPath.isEmpty()) {
            outputFilePath = userOutputPath;
        }

        System.out.print("Введите подстроку для удаления: ");
        String substringToRemove = scanner.nextLine();

        try {
            StringBuilder poem = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    poem.append(line).append(System.lineSeparator());
                }
            }

            String modifiedPoem = poem.toString().replace(substringToRemove, "");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write(modifiedPoem);
            }

            System.out.println("Подстрока удалена и результат записан в файл: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

package com.mkyong.examples.Chapter11.VariantA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseLinesFromFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к входному файлу: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Введите путь к выходному файлу: ");
        String outputFileName = scanner.nextLine();

        List<String> lines = readLinesFromFile(inputFileName);

        writeLinesToFileInReverse(lines, outputFileName);

        System.out.println("Строки записаны в файл '" + outputFileName + "' в обратном порядке.");
    }

    private static List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return lines;
    }

    private static void writeLinesToFileInReverse(List<String> lines, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = lines.size() - 1; i >= 0; i--) {
                writer.write(lines.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}

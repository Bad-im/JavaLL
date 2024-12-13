package com.mkyong.examples.Chapter2.VariantA;

import java.util.Scanner;

public class java3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        double averageLength = 0;
        for (int number : numbers) {
            averageLength += String.valueOf(number).length();
        }
        averageLength /= n;
        System.out.println("Числа с длиной меньше средней (" + averageLength + "):");
        for (int number : numbers) {
            int length = String.valueOf(number).length();
            if (length < averageLength) {
                System.out.println(number + ", длина: " + length);
            }
        }
        System.out.println();
        System.out.println("Числа с длиной больше средней (" + averageLength + "):");
        for (int number : numbers) {
            int length = String.valueOf(number).length();
            if (length > averageLength) {
                System.out.println(number + ", длина: " + length);
            }
        }
        System.out.println();
    }
}

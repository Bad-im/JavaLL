package com.mkyong.examples.Chapter2.VariantA;

import java.util.Arrays;
import java.util.Scanner;

public class java2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите число " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        System.out.println("Числа в порядке возрастания длины:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Arrays.sort(numbers);
        System.out.println("Числа в порядке убывания длины:");
        for(int i = 0; i < numbers.length / 2; i++)
        {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

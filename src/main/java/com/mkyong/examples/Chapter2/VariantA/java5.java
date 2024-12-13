package com.mkyong.examples.Chapter2.VariantA;

import java.util.Scanner;

public class java5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы массива (через пробел): ");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int countEvenDigits = 0;

        for (int num : arr) {
            if (hasOnlyEvenDigits(num)) {
                countEvenDigits++;
            }
        }

        int countEqualEvenOddDigits = 0;

        for (int num : arr) {
            if (hasEqualEvenOddDigits(num)) {
                countEqualEvenOddDigits++;
            }
        }

        // Print results
        System.out.println("Количество чисел, состоящих только из четных цифр: " + countEvenDigits);
        System.out.println("Количество чисел с одинаковым количеством четных и нечетных цифр: " + countEqualEvenOddDigits);
    }

    public static boolean hasOnlyEvenDigits(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 != 0) {
                return false;
            }
            num /= 10;
        }

        return true;
    }

    public static boolean hasEqualEvenOddDigits(int num) {
        int countEven = 0;
        int countOdd = 0;

        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
            num /= 10;
        }

        return countEven == countOdd;
    }
}

package com.mkyong.examples.Chapter2.VariantA;

import java.util.Scanner;

public class java4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы массива (через пробел): ");
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int result = findNumberWithLeastDistinctDigits(arr);

        System.out.println("Число с наименьшим количеством различных цифр: " + result);
    }

    public static int findNumberWithLeastDistinctDigits(int[] arr) {
        int minDistinctDigits = Integer.MAX_VALUE;
        int result = -1;

        for (int num : arr) {
            int[] digits = getDigits(num);
            int distinctDigits = getDistinctDigits(digits);

            if (distinctDigits < minDistinctDigits) {
                minDistinctDigits = distinctDigits;
                result = num;
            }
        }

        return result;
    }

    public static int[] getDigits(int num) {
        int[] digits = new int[10];

        while (num > 0) {
            int digit = num % 10;
            digits[digit]++;
            num /= 10;
        }

        return digits;
    }

    public static int getDistinctDigits(int[] digits) {
        int count = 0;

        for (int digit : digits) {
            if (digit > 0) {
                count++;
            }
        }

        return count;
    }
}

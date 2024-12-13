package com.mkyong.examples.Chapter2.VariantA;

import java.util.Scanner;

public class java8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int secondPalindrome = -1;
        boolean firstPalindromeFound = false;
        for (int i = 0; i < size; i++) {
            if (isPalindrome(arr[i])) {
                if (firstPalindromeFound) {
                    secondPalindrome = arr[i];
                    break;
                } else {
                    firstPalindromeFound = true;
                }
            }
        }

        // Print the result
        if (secondPalindrome == -1) {
            System.out.println("Второй палиндром не найден");
        } else {
            System.out.println("Второй палиндром: " + secondPalindrome);
        }
    }

    public static boolean isPalindrome(int number) {
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length() / 2; i++) {
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

package com.mkyong.examples.Chapter2.VariantA;

import java.util.Scanner;

public class java7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int result = -1;
        for (int i = 0; i < size; i++) {
            if (hasDistinctDigits(arr[i])) {
                result = arr[i];
                break;
            }
        }

        if (result == -1) {
            System.out.println("Не найдено ни одного номера с отдельными цифрами: ");
        } else {
            System.out.println("Первое число с отдельными цифрами:" + result);
        }
    }

    public static boolean hasDistinctDigits(int number) {
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            for (int j = i + 1; j < numberString.length(); j++) {
                if (numberString.charAt(i) == numberString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

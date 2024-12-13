package com.mkyong.examples.Chapter2.VariantA;

import java.util.Scanner;

public class java6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        int result = -1;
        for (int i = 0; i < size; i++) {
            if (isAscending(arr[i])) {
                result = arr[i];
                break;
            }
        }

        if (result == -1) {
            System.out.println("Число с возрастающими цифрами не найдено");
        } else {
            System.out.println("Первое число с возрастающими цифрами: " + result);
        }
    }

    public static boolean isAscending(int number) {
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length() - 1; i++) {
            if (numberString.charAt(i) > numberString.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

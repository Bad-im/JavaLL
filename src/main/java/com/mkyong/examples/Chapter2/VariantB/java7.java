package com.mkyong.examples.Chapter2.VariantB;

import java.util.Scanner;

public class java7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите десятичное число: ");
        int decimalNumber = scanner.nextInt();

        System.out.print("Введите основание системы счисления (от 2 до 36): ");
        int base = scanner.nextInt();

        if (base < 2 || base > 36) {
            System.out.println("Некорректное основание системы счисления");
            return;
        }

        String otherBaseNumber = "";
        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            char digit = Character.forDigit(remainder, base);
            otherBaseNumber = digit + otherBaseNumber;
            decimalNumber /= base;
        }

        System.out.println("Число в другой системе счисления: " + otherBaseNumber);
    }
}

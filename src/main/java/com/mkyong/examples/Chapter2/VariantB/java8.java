package com.mkyong.examples.Chapter2.VariantB;

import java.util.Scanner;

public class java8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исходное число: ");
        String number = scanner.nextLine();

        System.out.print("Введите основание исходной системы счисления (от 2 до 36): ");
        int fromBase = scanner.nextInt();

        System.out.print("Введите основание целевой системы счисления (от 2 до 36): ");
        int toBase = scanner.nextInt();

        if (fromBase < 2 || fromBase > 36 || toBase < 2 || toBase > 36) {
            System.out.println("Некорректные основания систем счисления");
            return;
        }

        int decimalNumber = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char digit = number.charAt(i);
            int digitValue = Character.digit(digit, fromBase);
            decimalNumber += digitValue * Math.pow(fromBase, number.length() - 1 - i);
        }

        String otherBaseNumber = "";
        while (decimalNumber > 0) {
            int remainder = decimalNumber % toBase;
            char digit = Character.forDigit(remainder, toBase);
            otherBaseNumber = digit + otherBaseNumber;
            decimalNumber /= toBase;
        }

        System.out.println("Число в целевой системе счисления: " + otherBaseNumber);
    }
}

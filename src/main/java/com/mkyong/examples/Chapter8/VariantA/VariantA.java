package com.mkyong.examples.Chapter8.VariantA;

import java.util.Scanner;

public class VariantA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите номер символа для замены (от 1 до длины слова):");
        int k = scanner.nextInt();

        System.out.println("Введите символ для замены:");
        char replacementChar = scanner.next().charAt(0);

        String replacedText = replaceKthCharacter(text, k, replacementChar);

        System.out.println("Замененный текст:");
        System.out.println(replacedText);
    }

    public static String replaceKthCharacter(String text, int k, char replacementChar) {
        StringBuilder replacedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i + 1 == k) {
                replacedText.append(replacementChar);
            } else {
                replacedText.append(text.charAt(i));
            }
        }

        return replacedText.toString();
    }
}

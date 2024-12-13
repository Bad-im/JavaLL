package com.mkyong.examples.Chapter1;
import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество случайных чисел:");
            int count = scanner.nextInt();

            Random random = new Random();

            System.out.println("Случайные числа без перехода на новую строку:");
            for (int i = 0; i < count; i++) {
                System.out.print(random.nextInt(11) + " ");
            }

            System.out.println("\nСлучайные числа с переходом на новую строку:");
            for (int i = 0; i < count; i++) {
                System.out.println(random.nextInt(11));
            }
        }
    }
}
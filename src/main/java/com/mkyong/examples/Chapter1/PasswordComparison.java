package com.mkyong.examples.Chapter1;
import java.util.Scanner;

public class PasswordComparison {

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();

            String samplePassword = "password123";

            boolean isCorrect = password.equals(samplePassword);

            if (isCorrect) {
                System.out.println("Пароль правильный.");
            } else {
                System.out.println("Пароль неправильный.");
            }
        }
    }
}
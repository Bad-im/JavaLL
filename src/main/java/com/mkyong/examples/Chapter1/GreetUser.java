package com.mkyong.examples.Chapter1;
import java.util.Scanner;

public class GreetUser {

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите ваше имя:");
            String name = scanner.next();
            System.out.println("Привет, " + name + "!");
        }
    }
}
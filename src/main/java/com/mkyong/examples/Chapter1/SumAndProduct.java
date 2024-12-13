package com.mkyong.examples.Chapter1;

public class SumAndProduct {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Необходимо ввести целые числа в качестве аргументов командной строки.");
            return;
        }

        int sum = 0;
        int product = 1;

        for (String arg : args) {
            int number = Integer.parseInt(arg);

            sum += number;

            product *= number;
        }

        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}
package com.mkyong.examples.Chapter2.VariantB;

public class java5 {

    public static void main(String[] args) {
        int number = 129;
        int count = 0;

        while (number % 2 == 0) {
            count++;

            number /= 2;
        }

        System.out.println("Количество значащих нулей в двоичной записи числа " + 129 + ": " + count);
    }
}

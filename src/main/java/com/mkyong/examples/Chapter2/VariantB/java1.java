package com.mkyong.examples.Chapter2.VariantB;

public class java1 {

    public static void main(String[] args) {
        int[][] table = new int[10][10];

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }

        for (int[] row : table) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }
}

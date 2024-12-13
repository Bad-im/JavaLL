package com.mkyong.examples.Chapter2.VariantB;

public class java3 {

    public static void main(String[] args) {
        int k = 7;
        int n = 4;
        int m = 7;

        if (k > n && k <= m) {
            System.out.println("k принадлежит интервалу (n, m]");
        } else if (k >= n && k < m) {
            System.out.println("k принадлежит интервалу [n, m)");
        } else if (k > n && k < m) {
            System.out.println("k принадлежит интервалу (n, m)");
        } else if (k >= n && k <= m) {
            System.out.println("k принадлежит интервалу [n, m]");
        } else {
            System.out.println("k не принадлежит ни одному из интервалов");
        }
    }
}

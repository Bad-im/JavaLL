package com.mkyong.examples.Chapter3.VariantB;

import java.util.Scanner;

public class FractionOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество дробей: ");
        int k = scanner.nextInt();

        Fraction[] fractions = new Fraction[k];

        for (int i = 0; i < k; i++) {
            System.out.printf("Для дроби %d введите числитель и знаменатель: ", i + 1);
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            fractions[i] = new Fraction(numerator, denominator);
        }

        System.out.println("Введенные дроби: ");
        for (Fraction fraction : fractions) {
            System.out.println(fraction);
        }

        FractionOperations operations = new FractionOperations();
        operations.processFractions(fractions);

        System.out.println("Результаты: ");
        for (Fraction fraction : fractions) {
            System.out.println(fraction);
        }
    }


    private void processFractions(Fraction[] fractions) {
        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i].add(fractions[i + 1]);
        }

        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i].subtract(fractions[i + 1]);
        }

        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i].multiply(fractions[i + 1]);
        }

        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i].divide(fractions[i + 1]);
        }
    }
}

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void add(Fraction other) {
        this.numerator = this.numerator * other.denominator + this.denominator * other.numerator;
        this.denominator = this.denominator * other.denominator;
    }

    public void subtract(Fraction other) {
        this.numerator = this.numerator * other.denominator - this.denominator * other.numerator;
        this.denominator = this.denominator * other.denominator;
    }

    public void multiply(Fraction other) {
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
    }

    public void divide(Fraction other) {
        this.numerator *= other.denominator;
        this.denominator *= other.numerator;
    }

    @Override
    public String toString() {
        return "[" + numerator + "/" + denominator + "]";
    }
}

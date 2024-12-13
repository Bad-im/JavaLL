package com.mkyong.examples.Chapter4.VarantB.FlowerShop.service;

import com.mkyong.examples.Chapter4.VarantB.FlowerShop.model.*;

import java.util.Scanner;

public class Florist {
    private Bouquet bouquet = new Bouquet();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("1. Добавить цветок");
            System.out.println("2. Показать букет");
            System.out.println("3. Посчитать стоимость букета");
            System.out.println("4. Отсортировать цветы по свежести");
            System.out.println("5. Найти цветы по длине стебля");
            System.out.println("0. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    addFlower();
                    break;
                case 2:
                    System.out.println(bouquet);
                    break;
                case 3:
                    System.out.println("Стоимость букета: " + bouquet.calculateTotalPrice());
                    break;
                case 4:
                    bouquet.sortFlowersByFreshness();
                    System.out.println("Цветы отсортированы по свежести.");
                    break;
                case 5:
                    findFlowersByStemLength();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void addFlower() {
        System.out.println("Введите тип цветка (Роза/Тюльпан): ");
        String type = scanner.nextLine();
        System.out.println("Введите цену: ");
        double price = scanner.nextDouble();
        System.out.println("Введите уровень свежести (1-5): ");
        int freshness = scanner.nextInt();
        System.out.println("Введите длину стебля: ");
        double stemLength = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        Flower flower;
        if (type.equalsIgnoreCase("Роза")) {
            flower = new Rose(price, freshness, stemLength);
        } else if (type.equalsIgnoreCase("Тюльпан")) {
            flower = new Tulip(price, freshness, stemLength);
        } else {
            System.out.println("Неверный тип цветка.");
            return;
        }

        bouquet.addFlower(flower);
        System.out.println("Цветок добавлен в букет.");
    }

    private void findFlowersByStemLength() {
        System.out.println("Введите минимальную длину стебля: ");
        double minLength = scanner.nextDouble();
        System.out.println("Введите максимальную длину стебля: ");
        double maxLength = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Цветы в указанном диапазоне длины стебля: " + bouquet.findFlowersByStemLength(minLength, maxLength));
    }
}

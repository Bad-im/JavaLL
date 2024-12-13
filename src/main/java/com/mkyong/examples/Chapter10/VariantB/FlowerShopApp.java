package com.mkyong.examples.Chapter10.VariantB;

import java.util.Scanner;

public class FlowerShopApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bouquet bouquet = new Bouquet();
        BouquetConnector connector = new BouquetConnector();
        String filename = "bouquet.dat";

        while (true) {
            System.out.println("1. Добавить цветок");
            System.out.println("2. Посчитать стоимость букета");
            System.out.println("3. Отсортировать цветы по свежести");
            System.out.println("4. Сохранить букет");
            System.out.println("5. Загрузить букет");
            System.out.println("6. Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите тип цветка (1 - Роза, 2 - Тюльпан): ");
                    int type = scanner.nextInt();
                    System.out.println("Введите цену цветка: ");
                    double price = scanner.nextDouble();
                    System.out.println("Введите свежесть цветка (1-3): ");
                    int freshness = scanner.nextInt();
                    if (type == 1) {
                        bouquet.addFlower(new Rose(price, freshness));
                    } else if (type == 2) {
                        bouquet.addFlower(new Tulip(price, freshness));
                    }
                    break;
                case 2:
                    System.out.println("Общая стоимость букета: " + bouquet.calculateTotalPrice());
                    break;
                case 3:
                    bouquet.sortFlowersByFreshness();
                    System.out.println("Цветы отсортированы по свежести.");
                    break;
                case 4:
                    connector.serializeBouquet(bouquet, filename);
                    System.out.println("Букет сохранен.");
                    break;
                case 5:
                    bouquet = connector.deserializeBouquet(filename);
                    System.out.println("Букет загружен: " + bouquet);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}

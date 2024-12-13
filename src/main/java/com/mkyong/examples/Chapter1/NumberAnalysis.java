package com.mkyong.examples.Chapter1;
import java.util.*;

public class NumberAnalysis {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите количество чисел:");
            int n = scanner.nextInt();

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Введите число " + (i + 1) + ":");
                numbers[i] = scanner.nextInt();
            }

            // 1. Четные и нечетные числа
            System.out.println("Четные числа:");
            for (int number : numbers) {
                if (number % 2 == 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            System.out.println("Нечетные числа:");
            for (int number : numbers) {
                if (number % 2 != 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            // 2. Наибольшее и наименьшее число
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }
            System.out.println("Наибольшее число: " + max);
            System.out.println("Наименьшее число: " + min);

            // 3. Числа, которые делятся на 3 или на 9
            System.out.println("Числа, которые делятся на 3 или на 9:");
            for (int number : numbers) {
                if (number % 3 == 0 || number % 9 == 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            // 4. Числа, которые делятся на 5 и на 7
            System.out.println("Числа, которые делятся на 5 и на 7:");
            for (int number : numbers) {
                if (number % 5 == 0 && number % 7 == 0) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            // 5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр
            System.out.println("Все трехзначные числа, в десятичной записи которых нет одинаковых цифр:");
            for (int number : numbers) {
                if (number >= 100 && number <= 999) {
                    int hundreds = number / 100;
                    int tens = (number % 100) / 10;
                    int units = number % 10;
                    if (hundreds != tens && tens != units && hundreds != units) {
                        System.out.print(number + " ");
                    }
                }
            }
            System.out.println();

            // 6. Простые числа
            System.out.println("Простые числа:");
            for (int number : numbers) {
                if (isPrime(number)) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            // 7. Отсортированные числа в порядке возрастания и убывания
            System.out.println("Отсортированные числа в порядке возрастания:");
            Arrays.sort(numbers);
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();

            System.out.println("Отсортированные числа в порядке убывания:");
            Arrays.sort(numbers);
            for (int i = numbers.length - 1; i >= 0; i--) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            // 8. Числа в порядке убывания частоты встречаемости чисел
            //??

            // 9. «Счастливые» числа
            System.out.println("«Счастливые» числа:");
            for (int number : numbers) {
                if (isHappy(number)) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            // 10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают
            System.out.println("Числа-палиндромы:");
            for (int number : numbers) {
                if (isPalindrome(number)) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();

            // 11. Элементы, которые равны полусумме соседних элементов
            System.out.println("Элементы, которые равны полусумме соседних элементов:");
            for (int i = 1; i < numbers.length - 1; i++) {
                if (numbers[i] == (numbers[i - 1] + numbers[i + 1]) / 2) {
                    System.out.print(numbers[i] + " ");
                }
            }
        }

        System.out.println();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHappy(int number) {
        Set<Integer> visitedNumbers = new HashSet<>();
        while (number != 1) {
            int sum = 0;
            while (number > 0) {
                int digit = number % 10;
                sum += digit * digit;
                number /= 10;
            }
            number = sum;
            if (visitedNumbers.contains(number)) {
                return false;
            }
            visitedNumbers.add(number);
        }
        return true;
    }

    private static boolean isPalindrome(int number) {
        int reversedNumber = 0;
        int originalNumber = number;
        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }
        return originalNumber == reversedNumber;
    }
}
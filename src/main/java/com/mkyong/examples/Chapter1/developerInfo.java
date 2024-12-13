package com.mkyong.examples.Chapter1;
import java.time.LocalDate;

public class developerInfo {

    public static void main(String[] args) {
        String developerName = "Астапов";

        LocalDate receiveDate = LocalDate.of(2024, 9, 7);

        LocalDate submitDate = LocalDate.of(2024, 9, 14);

        System.out.println("Фамилия разработчика: " + developerName);
        System.out.println("Дата получения задания: " + receiveDate);
        System.out.println("Дата сдачи задания: " + submitDate);
    }
}
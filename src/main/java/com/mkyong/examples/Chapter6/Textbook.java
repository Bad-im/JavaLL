package com.mkyong.examples.Chapter6;

public class Textbook implements Publication {
    @Override
    public void createContract() {
        System.out.println("Создан договор для учебного пособия.");
    }

    @Override
    public void editPublication() {
        System.out.println("Редактирование учебного пособия.");
    }

    @Override
    public void layoutPublication() {
        System.out.println("Верстка учебного пособия.");
    }

    @Override
    public void sendToPrint() {
        System.out.println("Учебное пособие отправлено на печать.");
    }

    @Override
    public void cancelPublication() {
        System.out.println("Издание учебного пособия отменено.");
    }

    @Override
    public void payForPublication() {
        System.out.println("Оплата учебного пособия произведена.");
    }

    @Override
    public void resumePublication() {
        System.out.println("Издание учебного пособия возобновлено.");
    }

    @Override
    public void closePublication() {
        System.out.println("Издание учебного пособия закрыто.");
    }
}

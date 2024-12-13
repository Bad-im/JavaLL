package com.mkyong.examples.Chapter6;

public class Book implements Publication {
    @Override
    public void createContract() {
        System.out.println("Создан договор для книги.");
    }

    @Override
    public void editPublication() {
        System.out.println("Редактирование книги.");
    }

    @Override
    public void layoutPublication() {
        System.out.println("Верстка книги.");
    }

    @Override
    public void sendToPrint() {
        System.out.println("Книга отправлена на печать.");
    }

    @Override
    public void cancelPublication() {
        System.out.println("Издание книги отменено.");
    }

    @Override
    public void payForPublication() {
        System.out.println("Оплата книги произведена.");
    }

    @Override
    public void resumePublication() {
        System.out.println("Издание книги возобновлено.");
    }

    @Override
    public void closePublication() {
        System.out.println("Издание книги закрыто.");
    }
}


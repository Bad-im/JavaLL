package com.mkyong.examples.Chapter6;

public class Magazine implements Publication {
    @Override
    public void createContract() {
        System.out.println("Создан договор для журнала.");
    }

    @Override
    public void editPublication() {
        System.out.println("Редактирование журнала.");
    }

    @Override
    public void layoutPublication() {
        System.out.println("Верстка журнала.");
    }

    @Override
    public void sendToPrint() {
        System.out.println("Журнал отправлен на печать.");
    }

    @Override
    public void cancelPublication() {
        System.out.println("Издание журнала отменено.");
    }

    @Override
    public void payForPublication() {
        System.out.println("Оплата журнала произведена.");
    }

    @Override
    public void resumePublication() {
        System.out.println("Издание журнала возобновлено.");
    }

    @Override
    public void closePublication() {
        System.out.println("Издание журнала закрыто.");
    }
}

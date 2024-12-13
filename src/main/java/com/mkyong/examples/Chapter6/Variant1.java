package com.mkyong.examples.Chapter6;

public class Variant1 {
    public static void main(String[] args) {
        Publication book = new Book();
        book.createContract();
        book.editPublication();
        book.layoutPublication();
        book.sendToPrint();
        book.payForPublication();
        book.closePublication();

        System.out.println();

        Publication magazine = new Magazine();
        magazine.createContract();
        magazine.editPublication();
        magazine.layoutPublication();
        magazine.sendToPrint();
        magazine.cancelPublication();
        magazine.resumePublication();
        magazine.closePublication();

        System.out.println();

        Publication textbook = new Textbook();
        textbook.createContract();
        textbook.editPublication();
        textbook.layoutPublication();
        textbook.sendToPrint();
        textbook.payForPublication();
        textbook.closePublication();
    }
}

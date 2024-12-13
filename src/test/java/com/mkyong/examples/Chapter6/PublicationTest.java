package com.mkyong.examples.Chapter6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicationTest {

    private Book book;
    private Magazine magazine;
    private Textbook textbook;

    @BeforeEach
    public void setUp() {
        book = new Book();
        magazine = new Magazine();
        textbook = new Textbook();
    }

    @Test
    public void testBookMethods() {
        assertDoesNotThrow(() -> {
            book.createContract();
            book.editPublication();
            book.layoutPublication();
            book.sendToPrint();
            book.cancelPublication();
            book.payForPublication();
            book.resumePublication();
            book.closePublication();
        });
    }

    @Test
    public void testMagazineMethods() {
        assertDoesNotThrow(() -> {
            magazine.createContract();
            magazine.editPublication();
            magazine.layoutPublication();
            magazine.sendToPrint();
            magazine.cancelPublication();
            magazine.payForPublication();
            magazine.resumePublication();
            magazine.closePublication();
        });
    }

    @Test
    public void testTextbookMethods() {
        assertDoesNotThrow(() -> {
            textbook.createContract();
            textbook.editPublication();
            textbook.layoutPublication();
            textbook.sendToPrint();
            textbook.cancelPublication();
            textbook.payForPublication();
            textbook.resumePublication();
            textbook.closePublication();
        });
    }
}

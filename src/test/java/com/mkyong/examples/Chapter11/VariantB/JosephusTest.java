package com.mkyong.examples.Chapter11.VariantB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JosephusTest {

    @Test
    public void testJosephusArrayList() {
        assertEquals(7, Josephus.josephusArrayList(7), "Последний оставшийся человек должен быть 7 для N=7");
        assertEquals(3, Josephus.josephusArrayList(5), "Последний оставшийся человек должен быть 3 для N=5");
        assertEquals(1, Josephus.josephusArrayList(1), "Последний оставшийся человек должен быть 1 для N=1");
    }

    @Test
    public void testJosephusLinkedList() {
        assertEquals(7, Josephus.josephusLinkedList(7), "Последний оставшийся человек должен быть 7 для N=7");
        assertEquals(3, Josephus.josephusLinkedList(5), "Последний оставшийся человек должен быть 3 для N=5");
        assertEquals(1, Josephus.josephusLinkedList(1), "Последний оставшийся человек должен быть 1 для N=1");
    }
}

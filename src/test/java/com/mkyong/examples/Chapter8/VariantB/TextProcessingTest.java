package com.mkyong.examples.Chapter8.VariantB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TextProcessingTest {

    @Test
    void testAddSentenceToParagraph() {
        Paragraph paragraph = new Paragraph();
        Sentence sentence = new Sentence();
        Word word1 = new Word("Hello");
        Word word2 = new Word("world");
        sentence.addWord(word1);
        sentence.addWord(word2);
        paragraph.addSentence(sentence);

        List<Sentence> sentences = paragraph.getSentences();
        assertEquals(1, sentences.size());
        assertTrue(sentences.get(0).containsWord("Hello"));
        assertTrue(sentences.get(0).containsWord("world"));
    }

    @Test
    void testContainsWord() {
        Sentence sentence = new Sentence();
        Word word1 = new Word("Hello");
        Word word2 = new Word("world");
        sentence.addWord(word1);
        sentence.addWord(word2);

        assertTrue(sentence.containsWord("Hello"));
        assertTrue(sentence.containsWord("world"));
        assertFalse(sentence.containsWord("Java"));
    }

    @Test
    void testFindMaxCountOfSentencesWithSameWords() {
        Paragraph paragraph = new Paragraph();

        Sentence sentence1 = new Sentence();
        sentence1.addWord(new Word("Hello"));
        sentence1.addWord(new Word("world"));

        Sentence sentence2 = new Sentence();
        sentence2.addWord(new Word("Hello"));

        Sentence sentence3 = new Sentence();
        sentence3.addWord(new Word("Hello"));

        paragraph.addSentence(sentence1);
        paragraph.addSentence(sentence2);
        paragraph.addSentence(sentence3);

        int maxCount = TextProcessing.findMaxCountOfSentencesWithSameWords(paragraph);
        assertEquals(3, maxCount);
    }
}

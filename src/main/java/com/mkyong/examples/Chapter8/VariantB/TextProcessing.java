package com.mkyong.examples.Chapter8.VariantB;

import java.util.*;

public class TextProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст учебника по программированию:");
        String text = scanner.nextLine();

        List<Paragraph> paragraphs = parseText(text);

        int maxCount = 0;
        for (Paragraph paragraph : paragraphs) {
            int count = findMaxCountOfSentencesWithSameWords(paragraph);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println("Наибольшее количество предложений с одинаковыми словами: " + maxCount);
    }

    public static List<Paragraph> parseText(String text) {
        List<Paragraph> paragraphs = new ArrayList<>();

        text = text.replaceAll("\\s+", " ");

        String[] paragraphTexts = text.split("\n\n");
        for (String paragraphText : paragraphTexts) {
            Paragraph paragraph = new Paragraph();

            String[] sentenceTexts = paragraphText.split("[.?!]");
            for (String sentenceText : sentenceTexts) {
                Sentence sentence = new Sentence();

                String[] wordTexts = sentenceText.split(" ");
                for (String wordText : wordTexts) {
                    Word word = new Word(wordText);
                    sentence.addWord(word);
                }

                paragraph.addSentence(sentence);
            }

            paragraphs.add(paragraph);
        }

        return paragraphs;
    }

    public static int findMaxCountOfSentencesWithSameWords(Paragraph paragraph) {
        int maxCount = 0;

        Set<String> uniqueWords = new HashSet<>();
        for (Sentence sentence : paragraph.getSentences()) {
            for (Word word : sentence.getWords()) {
                uniqueWords.add(word.getText());
            }
        }

        for (String uniqueWord : uniqueWords) {
            int count = 0;
            for (Sentence sentence : paragraph.getSentences()) {
                if (sentence.containsWord(uniqueWord)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}

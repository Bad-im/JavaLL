package com.mkyong.examples.Chapter4.VarantA;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences;
    private String title;

    public Text(String title) {
        this.title = title;
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public void printText() {
        System.out.println(title);
        for (Sentence sentence : sentences) {
            System.out.println(sentence);
        }
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append("\n");
        for (Sentence sentence : sentences) {
            sb.append(sentence).append("\n");
        }
        return sb.toString();
    }
}

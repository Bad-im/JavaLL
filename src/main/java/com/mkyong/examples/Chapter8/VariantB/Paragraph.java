package com.mkyong.examples.Chapter8.VariantB;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    private List<Sentence> sentences;

    public Paragraph() {
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        this.sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return this.sentences;
    }
}

package com.mkyong.examples.Chapter8.VariantB;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private List<Word> words;

    public Sentence() {
        this.words = new ArrayList<>();
    }

    public void addWord(Word word) {
        this.words.add(word);
    }

    public List<Word> getWords() {
        return this.words;
    }

    public boolean containsWord(String wordText) {
        for (Word word : this.words) {
            if (word.getText().equals(wordText)) {
                return true;
            }
        }

        return false;
    }
}

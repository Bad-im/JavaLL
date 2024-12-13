package com.mkyong.examples.Chapter4.VarantA;

public class Main {
    public static void main(String[] args) {
        Text text = new Text("Первый вариант");

        Sentence sentence1 = new Sentence();
        sentence1.addWord(new Word("Это"));
        sentence1.addWord(new Word("первое"));
        sentence1.addWord(new Word("предложение"));

        Sentence sentence2 = new Sentence();
        sentence2.addWord(new Word("А"));
        sentence2.addWord(new Word("это"));
        sentence2.addWord(new Word("второе"));
        sentence2.addWord(new Word("предложение"));

        text.addSentence(sentence1);
        text.addSentence(sentence2);

        text.printText();
    }
}

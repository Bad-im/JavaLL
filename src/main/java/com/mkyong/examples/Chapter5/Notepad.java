package com.mkyong.examples.Chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notepad {
    private class Note {
        private String date;
        private String text;

        public Note(String date, String text) {
            this.date = date;
            this.text = text;
        }

        @Override
        public String toString() {
            return "Дата: " + date + ", Заметка: " + text;
        }
    }

    private Map<String, List<Note>> notesByDate;

    public Notepad() {
        notesByDate = new HashMap<>();
    }

    public void addNote(String date, String text) {
        Note newNote = new Note(date, text);
        notesByDate.putIfAbsent(date, new ArrayList<>());
        notesByDate.get(date).add(newNote);
    }

    public void showNotes(String date) {
        List<Note> notes = notesByDate.get(date);
        if (notes != null && !notes.isEmpty()) {
            System.out.println("Заметки на " + date + ":");
            for (Note note : notes) {
                System.out.println(note);
            }
        } else {
            System.out.println("Нет заметок на " + date);
        }
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.addNote("2023-10-01", "Первая заметка");
        notepad.addNote("2023-10-01", "Вторая заметка");
        notepad.addNote("2023-10-02", "Заметка на другой день");

        notepad.showNotes("2023-10-01");
        notepad.showNotes("2023-10-02");
        notepad.showNotes("2023-10-03");
    }
}

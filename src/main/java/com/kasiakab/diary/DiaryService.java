package com.kasiakab.diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryService {

    private final List<Note> notes = new ArrayList<>();

    public void addNote(String content) {
        notes.add(new Note(content));
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }

    public void removeNote(int number) {
        if (number < 0 || number >= notes.size()) {
            throw new IllegalArgumentException("Invalid note number " + number);
        }
        notes.remove(number);
    }

}

package com.kasiakab.diary;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "diary.txt";

    public void saveToFile(List<Note> notes) {
        try (
                FileWriter fileWriter = new FileWriter(FILE_NAME, true);
                var writer = new BufferedWriter(fileWriter)
            ) {
            for (Note note : notes) {
                writer.write(note.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.printf("Failed to save into a file %s.", FILE_NAME   );
        }
    }

    public List<Note> loadFromFile() {
        /* Plik przechowuje tekst, program zwraca obiekt Note, parsujemy tekst na obiekt typu Note*/
        List<Note> notes = new ArrayList<>();
        try (
                FileReader fileReader = new FileReader(FILE_NAME);
                var reader = new BufferedReader(fileReader)
                ) {
            String nextLine;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

            /* Wyciągamy datę: szukamy "[ " i " ]" */
            while ((nextLine = reader.readLine()) != null) {
                try {
                    Note note = getNote(nextLine, formatter);
                    notes.add(note);
                } catch (Exception ex) {
                    System.err.println("Skipping invalid line: " + nextLine);
                }

            }
        } catch (IOException ex) {
            System.err.printf("Failed to read a file %s.", FILE_NAME);
        }
        return notes;
    }

    private static Note getNote(String nextLine, DateTimeFormatter formatter) {
        int start = nextLine.indexOf("[ ") + 2;
        int end = nextLine.indexOf(" ]");
        String dateString = nextLine.substring(start, end);

        LocalDateTime date = LocalDateTime.parse(dateString, formatter);

        /* Wyciągamy treść, wszystko po " ] " */
        int contentStart = nextLine.indexOf(" ] ") + 3;
        String content = nextLine.substring(contentStart);

        /* Tworzymy obiekt Note i dodajmy do listy */
        Note note = new Note(date, content);
        return note;
    }
}

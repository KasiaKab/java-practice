package com.kasiakab.diary;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = 
            "C:/Users/kasia/Java Learning/my-java-practice/java-practice/src/main/java/com/kasiakab/diary/diary.txt";

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
            System.err.printf("Failed to save into a file %s.", FILE_NAME);
        }
    }

    public List<Note> loadFromFile() {
        /* Plik przechowuje tekst, program zwraca obiekt Note, parsujemy tekst na obiekt typu Note*/
        List<Note> notes = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (file.exists()) {
            return notes;
        }

        try (
                FileReader fileReader = new FileReader(FILE_NAME);
                var reader = new BufferedReader(fileReader)
        ) {
            String nextLine;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

            while ((nextLine = reader.readLine()) != null) {
                try {
                    Note note = getNote(nextLine, formatter);
                    notes.add(note);
                } catch (Exception ex) {
                    System.err.println("Skipping invalid line: " + nextLine);
                }
            }
        } catch (IOException ex) {
            System.err.printf("Failed to read a file %s%n", FILE_NAME);
        }
        return notes;
    }

    private static Note getNote(String nextLine, DateTimeFormatter formatter) {
        LocalDateTime date = parseDate(nextLine, formatter);
        String content = parseContent(nextLine);
        return createNote(date, content);
    }

    private static LocalDateTime parseDate(String nextLine, DateTimeFormatter formatter) {
        /* Wyciągamy datę: szukamy "[ " i " ]" */
        int start = nextLine.indexOf("[ ") + 2;
        int end = nextLine.indexOf(" ]");
        String dateString = nextLine.substring(start, end);
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date;
    }

    private static String parseContent(String nextLine) {
        /* Wyciągamy treść, wszystko po " ] " */
        int contentStart = nextLine.indexOf(" ]") + 3;
        String content = nextLine.substring(contentStart);
        return content;
    }

    private static Note createNote(LocalDateTime date, String content) {
        /* Tworzymy obiekt Note i dodajmy do listy */
        Note note = new Note(date, content);
        return note;
    }
}

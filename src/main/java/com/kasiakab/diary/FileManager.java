package com.kasiakab.diary;

import java.io.*;
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
        List<Note> notes = new ArrayList<>();
        try (
                FileReader fileReader = new FileReader(FILE_NAME);
                var reader = new BufferedReader(fileReader)
                ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
            }
        } catch (IOException ex) {
            System.err.printf("Failed to read a file %s.", FILE_NAME);
        }
        return notes;
    }
}

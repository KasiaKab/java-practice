package com.kasiakab.diary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
            System.err.format("Failed to save into a file %s.", FILE_NAME   );


        }

    }
}

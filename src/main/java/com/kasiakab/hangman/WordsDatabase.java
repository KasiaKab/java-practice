package com.kasiakab.hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordsDatabase {

    private List<String> words;

    public WordsDatabase() {

        try {
            this.words = Files.readAllLines(Paths
                    .get("C:/Users/kasia/Java Learning/my-java-practice/java-practice/src/main/java/com/kasiakab/hangman/words_database.txt"));
        } catch (IOException e) {
            System.err.println("Error reading words database: " + e.getMessage());
        }
    }

    public String getRandomWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

}

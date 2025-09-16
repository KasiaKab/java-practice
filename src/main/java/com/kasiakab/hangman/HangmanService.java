package com.kasiakab.hangman;

import java.util.HashSet;
import java.util.Set;

public class HangmanService {

    private String secretWord;
    private boolean[] guessedLetters; // Czy każda litera w haśle została odgadnięta? (indeks = pozycja w haśle)
    private Set<Character> usedLetters; // Litery, które użytkownik już podał, Set<> automatycznie uniemożliwia duplikaty
    private int mistakes;
    private static final int MAX_MISTAKES = 8;

    public HangmanService(String secretWord) {
        this.secretWord = secretWord;
        this.guessedLetters = new boolean[secretWord.length()];
        this.usedLetters = new HashSet<>(); // Diamond operator — Java samodzielnie „dopasowuje” typ na podstawie lewej strony
        this.mistakes = 0;
    }

    public boolean makeGuess(char letter) {

        // Krok 1: jeśli litera już była — ignorujemy
        if (usedLetters.contains(letter)) {
            return false;
        }

        // Krok 2: dodajemy literę do użycia
        usedLetters.add(letter);

        // Krok 3: szukamy litery w haśle i odkrywamy pasujące pozycje
        boolean found = false;                                          // Czy litera wystąpiła choć raz?
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {                       // Jeśli litera pasuje
                guessedLetters[i] = true;                               // → odkrywamy tę pozycję
                found = true;
            }
        }

        // Krok 4: jeśli nie znaleziono — zwiększamy licznik błędów
        if (!found) {
            mistakes++;
        }

        // Krok 5: coś się zmieniło — zwracamy true
        return true;
    }


    /*
        secretWord → np. "java"
        guessedLetters → np. [true, false, false, true]

        i=0: true -> dodaj 'j' -> "j"
        i=1: false -> dodaj '*' -> "j*"
        i=2: false -> dodaj '*' -> "j**"
        i=3: true -> dodaj 'a' -> "j**a"
    */

    public String getCurrentState() {
        StringBuilder state = new StringBuilder();           // Pusty łancuch, do którego bd dodawać
        for (int i = 0; i < guessedLetters.length; i++) {
            if (guessedLetters[i] == true) {
                state.append(secretWord.charAt(i));
            } else {
                state.append(secretWord.charAt('*'));
            }
        }
        return state.toString();
    }


    public boolean isWin() {
        for (int i = 0; i < guessedLetters.length; i++) {
            if (!guessedLetters[i]) {                       // jeśli choć jedna litera NIE jest odgadnięta
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        if (isWin() || mistakes >= MAX_MISTAKES) {
            return true;
        }
        return false;
    }

}






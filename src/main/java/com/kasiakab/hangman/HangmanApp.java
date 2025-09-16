package com.kasiakab.hangman;

public class HangmanApp {

    private ConsoleReader reader;
    private WordsDatabase wordsDatabase;
    private HangmanService hangmanService;

    public HangmanApp() {
        this.reader = new ConsoleReader();
        this.wordsDatabase = new WordsDatabase();
        this.hangmanService = null;
    }
    public void run() {
        reader.showMessage("=== Hangman :X ==");

        // zewnętrzna pętla — całe "menu gry"
        while (true) {

            // 1. Losuj słowo i zacznij grę
            String word = wordsDatabase.getRandomWord();
            hangmanService = new HangmanService(word);

            // 2. Pętla zgadywania — trwa, dopóki gra nie skończona
            while (!hangmanService.isGameOver()) {
                reader.showMessage("Secret word: " + hangmanService.getCurrentState());
                reader.showMessage("Your mistakes: " + hangmanService.getMistakes() + "/8");
                reader.showMessage("Enter your letter: ");

                String input = reader.readLine();
                if (input.isEmpty()) continue;
                char letter = input.charAt(0);

                hangmanService.makeGuess(letter);
            }

            // 3. Gra się skończyła — pokaż wynik
            if (hangmanService.isWin()) {
                reader.showMessage("You win! The word was: " + hangmanService.getSecretWord());
            } else {
                reader.showMessage("Game over! The word was: " + hangmanService.getSecretWord());
            }

            reader.showMessage("Choose an option:");
            reader.displayGameOptions();

            String input = reader.readLine();
            switch (input) {
                case "1" -> reader.showMessage("");
                case "2" -> {
                    reader.showMessage("Bye bye!");
                    System.exit(0);
                }
                default -> reader.showMessage("Invalid option. Try again.");
            }
        }
    }
}
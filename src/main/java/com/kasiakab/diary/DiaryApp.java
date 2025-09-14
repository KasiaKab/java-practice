package com.kasiakab.diary;


import java.util.List;

public class DiaryApp {

    private ConsoleReader reader;
    private DiaryService diaryService;
    private FileManager fileManager;

    public DiaryApp() {
        this.reader = new ConsoleReader();
        this.diaryService = new DiaryService();
        this.fileManager = new FileManager();
    }

    public void run() {
        reader.showMessage("=== Welcome to Your Diary ===");

        /* Wczytujemy istniejące notatki */
        List<Note> loadedNotes = fileManager.loadFromFile();
        for (Note note : loadedNotes) {
            diaryService.addNote(note.getContent());
        }

        while (true) {
            reader.displayMenu();

            try {
                MenuOptions option = reader.readMenuOption();
                switch (option) {
                    case ADD -> handleAdd();
                    case LIST -> handleList();
                    case DELETE -> handleDelete();
                    case EXIT -> {
                        reader.close();
                        reader.showMessage("See you next time!");
                        return;
                    }
                    default -> reader.showMessage("Unknown option. Please try again.");
                }
            } catch (IllegalArgumentException ex) {
                reader.showMessage("Invalid option. Please select 1–" + MenuOptions.values().length);
            }
        }
    }

    private void handleAdd() {
        reader.showMessage("Enter your note: ");
        String content = reader.readLine();
        diaryService.addNote(content);
        fileManager.saveToFile(diaryService.getAllNotes());
        reader.showMessage("Note added and saved.");
    }

    private void handleList() {
        List<Note> notes = diaryService.getAllNotes();
        displayNotes(notes);
    }

    private void displayNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            reader.showMessage("No notes yet.");
            return;
        }
        reader.showMessage("Your notes:");
        for (int i = 0; i < notes.size(); i++) {
            reader.showMessage((i + 1) + ". " + notes.get(i).toString());
        }
    }

    private void handleDelete() {
        List<Note> notes = diaryService.getAllNotes();
        if (notes.isEmpty()) {
            reader.showMessage("No notes to delete.");
            return;
        }
        reader.showMessage("Enter note number to delete (1-" + notes.size() + "):");
        try {
            int number = Integer.parseInt(reader.readLine());
            if (number < 1 || number > notes.size()) {
                reader.showMessage("Invalid number. Please enter 1-" + notes.size());
                return;
            }
            diaryService.removeNote(number - 1);
            fileManager.saveToFile(diaryService.getAllNotes());
            reader.showMessage("Note deleted.");
        } catch (NumberFormatException ex) {
            reader.showMessage("Please enter a valid number.");
        }
    }
}

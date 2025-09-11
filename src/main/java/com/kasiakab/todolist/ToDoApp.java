package com.kasiakab.todolist;

import java.util.List;

public class ToDoApp {

    private static final ToDoService toDoService = new ToDoService();

    public static void run() {
        ConsoleReader.welcomeMessage();

        while (true) {
            ConsoleReader.displayMenu();
            int choice = ConsoleReader.readInt("Chosen option: ");

            try {
                MenuOption option = getOption(choice);
                switch (option) {
                    case ADD -> handleAdd();
                    case LIST -> handleList();
                    case EDIT -> handleEdit();
                    case REMOVE -> handleRemove();
                    case EXIT -> {
                        ConsoleReader.close();
                        ConsoleReader.println("Goodbye!");
                        return;
                    }
                    default -> ConsoleReader.showError("Unknown option. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                ConsoleReader.showError("Invalid choice. Please select 1–" + MenuOption.values().length);
            }
        }
    }

    private static void handleAdd() {
        String task = ConsoleReader.readString("Enter task: ");
        toDoService.addTask(task);
        ConsoleReader.showSuccess("Task added successfully.");
    }

    private static void handleList() {
        List<String> tasks = toDoService.getAllTasks();
        if (tasks.isEmpty()) {
            ConsoleReader.println("No tasks yet. Add one!");
            return;
        }
        ConsoleReader.println("\nYOUR TASKS:");
        for (int i = 0; i < tasks.size(); i++) {
            ConsoleReader.println((i + 1) + ". " + tasks.get(i));
        }
        ConsoleReader.println();
    }

    private static void handleEdit() {
        int num = ConsoleReader.readInt("Enter task number to edit: ") - 1;
        String newDescription = ConsoleReader.readString("New description: ");
        if (toDoService.editTask(num, newDescription)) {
            ConsoleReader.showSuccess("Task #" + (num + 1) + " updated to: " + newDescription);
        } else {
            ConsoleReader.showError("Invalid task number.");
        }
    }

    private static void handleRemove() {
        int num = ConsoleReader.readInt("Enter task number to remove: ") - 1;
        if (toDoService.removeTask(num)) {
            ConsoleReader.showSuccess("Task #" + (num + 1) + " removed.");
        } else {
            ConsoleReader.showError("Invalid task number.");
        }
    }

    private static MenuOption getOption(int choice) {
        /*Zwraca tablicę wartości enuma w kolejności definicji (indeksy 0,1,2...),
        użytkownik wybiera od 1 → dlatego choice - 1, żeby dopasować do indeksu tablicy.*/
        MenuOption[] options = MenuOption.values();
        if (choice < 1 || choice > options.length) {
            throw new IllegalArgumentException("Invalid choice " + choice);
        }
        return options[choice - 1];
    }

}
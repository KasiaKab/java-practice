package com.kasiakab.library;

public enum ConsoleOption {

    ADD_BOOK("Add a new book"),
    FIND_BOOK("Find a book by ISBN"),
    REMOVE_BOOK("Remove a book by ISBN"),
    SHOW_ALL_BOOKS("Show all books"),
    GENERATE_RAPORT("Generate and save library report to file"),
    EXIT("Exit the application");

    private final String description;

    ConsoleOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

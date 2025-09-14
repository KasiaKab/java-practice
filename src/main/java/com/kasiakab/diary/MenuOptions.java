package com.kasiakab.diary;

public enum MenuOptions {

    ADD("Add new note"),
    LIST("Show all notes"),
    DELETE("Delete note by number"),
    EXIT("Exit");

    private final String description;

    MenuOptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

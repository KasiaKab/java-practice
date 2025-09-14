package com.kasiakab.diary;

public enum MenuOptions {

    ADD("Add new post"),
    LIST("Show all posts"),
    DELETE("Delete post by number");

    private final String description;

    MenuOptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

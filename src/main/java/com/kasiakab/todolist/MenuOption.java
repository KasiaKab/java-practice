package com.kasiakab.todolist;

public enum MenuOption {

    ADD("Add new task"),
    LIST("Show all tasks"),
    EDIT("Edit task by number"),
    REMOVE("Remove task by number"),
    EXIT("Exit");

    private final String description;

    MenuOption(String description1) {
        this.description = description1;
    }

    public String getDescription() {
        return description;
    }
}

package com.kasiakab.hangman;

public enum GameOption {

    KEEP_PLAYING("Keep playing"),
    EXIT("Exit");

    private String description;

    GameOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

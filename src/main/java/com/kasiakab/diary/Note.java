package com.kasiakab.diary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Note {
    private LocalDateTime date;
    private String content;

    public Note(String content) {
        this.date = LocalDateTime.now();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("[ %s ] %s", date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), content);
    }
}

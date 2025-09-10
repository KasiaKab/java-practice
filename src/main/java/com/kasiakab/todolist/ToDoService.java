package com.kasiakab.todolist;

import java.util.ArrayList;
import java.util.List;

public class ToDoService {

    /*Utility class = bez stanu = tylko statyczne metody = blokujemy konstruktor (private)
    Klasa ze stanem = ma pola = tworzy obiekt = konstruktor publiczny (lub domyślny)*/

    private List<String> tasks = new ArrayList<>();


    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> getAllTasks() {
        return tasks;
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public void editTask(String task) {
        tasks.set(tasks.indexOf(task), task);
    }
}

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

    public boolean removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            return true;
        }
        return false;
    }

    public boolean editTask(int index, String task) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, task);
            return true;
        }
        /*nieudana edycja*/
        return false;
    }
}

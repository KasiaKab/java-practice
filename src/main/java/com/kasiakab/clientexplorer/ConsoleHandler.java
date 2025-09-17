package com.kasiakab.clientexplorer;

import java.util.Scanner;

public class ConsoleHandler {

    private final Scanner scanner = new Scanner(System.in);

    public ConsoleHandler() {
    }

    ;

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void showInLine(String message) {
        System.out.print(message);
    }

    public void showProgress(String message) {
        System.out.print(message);
    }

    public void newLine() {
        System.out.println();
    }

}

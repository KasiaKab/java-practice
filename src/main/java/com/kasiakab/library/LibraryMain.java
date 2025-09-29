package com.kasiakab.library;

public class LibraryMain {
    public static void main(String[] args) {

        BookRepository repository = new BookRepository();
        BookService service = new BookService(repository);
        ConsoleHandler console = new ConsoleHandler();
        LibraryApp app = new LibraryApp(service, console);
        app.run();
    }
}

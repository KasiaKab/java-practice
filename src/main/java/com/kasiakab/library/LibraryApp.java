package com.kasiakab.library;

import java.util.List;
import java.util.Optional;

public class LibraryApp {

    private final BookService bookService;
    private final ConsoleHandler consoleHandler;

    public LibraryApp(BookService bookService, ConsoleHandler consoleHandler) {
        this.bookService = bookService;
        this.consoleHandler = consoleHandler;
    }

    public void run() {
        while (true) {
            consoleHandler.showMessage("== Welcome to Library App ==");
            consoleHandler.showMessage("Please chose the option:");
            consoleHandler.displayOption();
            ConsoleOption selectedOption = consoleHandler.readOption();
            switch (selectedOption) {
                case ADD_BOOK -> handleAddBook();
                case FIND_BOOK -> handleFindBook();
                case REMOVE_BOOK -> handleRemoveBook();
                case SHOW_ALL_BOOKS -> handleShowAllBooks();
                case GENERATE_REPORT -> handleGenerateReport();
                case EXIT -> {
                    consoleHandler.showMessage("Goodbye!");
                    return;
                }
            }
        }
    }

    private void handleGenerateReport() {

    }

    private void handleShowAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        if (allBooks.isEmpty()) {
            consoleHandler.showMessage("No books found!");
        }  else {
            consoleHandler.showMessage("All books in the library:");
            allBooks.forEach(book -> consoleHandler.showMessage(book.toString()));
        }

    }

    private void handleRemoveBook() {
        consoleHandler.showMessage("Please enter the ISBN of a book you would like to remove:");
        String isbn = consoleHandler.readString().trim();
        try {
            bookService.removeBookByIsbn(isbn);
            consoleHandler.showMessage("Removed the book successfully.");
        } catch (BookNotFoundException e) {
            consoleHandler.showMessage("Error: " + e.getMessage());
        }
    }

    private void handleFindBook() {
        consoleHandler.showMessage("Please enter the ISBN:");
        String isbn = consoleHandler.readString().trim();

        Optional<Book> book = bookService.findBookByIsbn(isbn);
        if (book.isPresent()) {
            consoleHandler.showMessage("Found: " + book.get());
        } else {
            consoleHandler.showMessage("Book with ISBN " + isbn + " not found!");
        }
    }

    private void handleAddBook() {
        consoleHandler.showMessage("Please enter the book title:");
        String title = consoleHandler.readString().trim();

        consoleHandler.showMessage("Please enter the author:");
        String author = consoleHandler.readString().trim();

        consoleHandler.showMessage("Please enter the ISBN:");
        String isbn = consoleHandler.readString().trim();

        createBook(title, author, isbn);
    }

    private void createBook(String title, String author, String isbn) {
        try {
            Book book = new Book(title, author, isbn);
            bookService.addBook(book);
            consoleHandler.showMessage("Book added successfully!");
        } catch (IllegalArgumentException e) {
            consoleHandler.showMessage("Error: " + e.getMessage());
        }
    }

}


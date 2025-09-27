package com.kasiakab.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.isbn(),  book);
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public void removeBookByIsbn(String isbn) {
        if (!books.containsKey(isbn)) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
        }
        books.remove(isbn);
    }
}

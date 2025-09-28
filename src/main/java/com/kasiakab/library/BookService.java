package com.kasiakab.library;

import java.util.List;
import java.util.Optional;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    public void removeBookByIsbn(String isbn) {
        bookRepository.removeBookByIsbn(isbn);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

}

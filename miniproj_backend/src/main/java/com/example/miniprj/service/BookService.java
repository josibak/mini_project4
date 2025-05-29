package com.example.miniprj.service;

import com.example.miniprj.entity.Book;
import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
}

package com.example.miniprj.service;

import com.example.miniprj.entity.Book;
import java.util.List;
import com.example.miniprj.dto.BookRequestDto;
import com.example.miniprj.dto.BookResponseDto;

public interface BookService {
//    Book createBook(Book book);
//    List<Book> getAllBooks();
//    Book getBookById(Long id);
//    Book updateBook(Long id, Book book);
//    void deleteBook(Long id);

    //after DTO
    BookResponseDto createBook(BookRequestDto dto);
    BookResponseDto getBook(Long id);
    List<BookResponseDto> getAllBooks();
    BookResponseDto updateBook(Long id, BookRequestDto dto);
    void deleteBook(Long id);
}

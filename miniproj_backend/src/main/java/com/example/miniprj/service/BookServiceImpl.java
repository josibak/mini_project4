package com.example.miniprj.service;

import com.example.miniprj.dto.BookRequestDto;
import com.example.miniprj.dto.BookResponseDto;
import com.example.miniprj.entity.Book;
import com.example.miniprj.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponseDto createBook(BookRequestDto dto) {
        Book book = Book.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .coverImageUrl(dto.getCoverImageUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return new BookResponseDto(bookRepository.save(book));
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getBook(Long id) {
        return bookRepository.findById(id)
                .map(BookResponseDto::new)
                .orElse(null);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto dto) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(dto.getTitle());
            book.setDescription(dto.getDescription());
            book.setCoverImageUrl(dto.getCoverImageUrl());
            book.setUpdatedAt(LocalDateTime.now());
            return new BookResponseDto(bookRepository.save(book));
        }).orElse(null);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

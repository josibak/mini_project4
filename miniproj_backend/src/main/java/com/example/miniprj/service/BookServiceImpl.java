package com.example.miniprj.service;

import com.example.miniprj.dto.BookRequestDto;
import com.example.miniprj.dto.BookResponseDto;
import com.example.miniprj.entity.Book;
import com.example.miniprj.repository.BookRepository;
import com.example.miniprj.exception.BookCreateException;
import com.example.miniprj.exception.BookNotFoundException;
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

    // 책 등록 (Book Create)
    @Override
    public BookResponseDto createBook(BookRequestDto dto) {
        // 값 누락 등 잘못된 요청 처리 (400)
        if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
            throw new BookCreateException("값이 누락되었거나 유효하지 않습니다.");
        }
        Book book = Book.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .coverImageUrl(dto.getCoverImageUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return new BookResponseDto(bookRepository.save(book));
    }

    // 전체 책 목록 조회
    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponseDto::new)
                .collect(Collectors.toList());
    }

    // 단일 책 조회 (404 예외 처리)
    @Override
    public BookResponseDto getBook(Long id) {
        return bookRepository.findById(id)
                .map(BookResponseDto::new)
                .orElseThrow(() -> new BookNotFoundException("해당 책을 찾을 수 없습니다."));
    }

    // 책 일부 수정 (404 예외 처리)
    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto dto) {
        return bookRepository.findById(id).map(book -> {
            if (dto.getTitle() != null) book.setTitle(dto.getTitle());
            if (dto.getDescription() != null) book.setDescription(dto.getDescription());
            if (dto.getCoverImageUrl() != null) book.setCoverImageUrl(dto.getCoverImageUrl());
            book.setUpdatedAt(LocalDateTime.now());
            return new BookResponseDto(bookRepository.save(book));
        }).orElseThrow(() -> new BookNotFoundException("해당 책을 찾을 수 없습니다."));
    }

    // 책 삭제 (404 예외 처리)
    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("해당 책을 찾을 수 없습니다.");
        }
        bookRepository.deleteById(id);
    }
}

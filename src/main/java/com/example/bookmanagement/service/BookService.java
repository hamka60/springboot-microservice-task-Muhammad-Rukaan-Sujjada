package com.example.bookmanagement.service;

import com.example.bookmanagement.dto.BookPatchRequest;
import com.example.bookmanagement.dto.BookRequest;
import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.exception.BookNotFoundException;
import com.example.bookmanagement.repository.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(BookRequest request) {

        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublishedDate(request.getPublishedDate());

        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findById(Long id) {

        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book update(Long id, BookRequest request) {

        Book book = findById(id);

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublishedDate(request.getPublishedDate());

        return bookRepository.save(book);
    }

    public Book patch(Long id, BookPatchRequest request) {

        Book book = findById(id);

        if (request.getTitle() != null) {
            book.setTitle(request.getTitle());
        }

        if (request.getAuthor() != null) {
            book.setAuthor(request.getAuthor());
        }

        if (request.getIsbn() != null) {
            book.setIsbn(request.getIsbn());
        }

        if (request.getPublishedDate() != null) {
            book.setPublishedDate(request.getPublishedDate());
        }

        return bookRepository.save(book);
    }

    public void delete(Long id) {

        Book book = findById(id);

        bookRepository.delete(book);
    }
}
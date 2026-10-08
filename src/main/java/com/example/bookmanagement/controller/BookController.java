package com.example.bookmanagement.controller;

import com.example.bookmanagement.dto.BookPatchRequest;
import com.example.bookmanagement.dto.BookRequest;
import com.example.bookmanagement.entity.Book;
import com.example.bookmanagement.service.BookService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST /api/books
    @PostMapping
    public ResponseEntity<Book> create(
            @Valid @RequestBody BookRequest request) {

        Book book = bookService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(book);
    }

    // GET /api/books
    @GetMapping
    public ResponseEntity<List<Book>> findAll() {

        return ResponseEntity.ok(
                bookService.findAll()
        );
    }

    // GET /api/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                bookService.findById(id)
        );
    }

    // PUT /api/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest request) {

        return ResponseEntity.ok(
                bookService.update(id, request)
        );
    }

    // PATCH /api/books/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<Book> patch(
            @PathVariable Long id,
            @Valid @RequestBody BookPatchRequest request) {

        return ResponseEntity.ok(
                bookService.patch(id, request)
        );
    }

    // DELETE /api/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        bookService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
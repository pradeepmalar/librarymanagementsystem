package com.library.controller;

import com.library.entity.book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000") 
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public book addBook(@RequestBody book book) {
        return bookService.saveBook(book);
    }
}
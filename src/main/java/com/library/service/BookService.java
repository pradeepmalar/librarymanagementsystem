package com.library.service;

import com.library.entity.book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<book> getAllBooks() {
        return bookRepository.findAll();
    }

    public book saveBook(book book) {
        return bookRepository.save(book);
    }
}
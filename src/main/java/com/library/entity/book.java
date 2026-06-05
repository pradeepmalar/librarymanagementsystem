package com.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String author;

    @Column(name = "publish_year", nullable = false)
    private Integer publishYear;

    public book() {}

    public Integer getBook_id() { return book_id; }
    public void setBook_id(Integer book_id) { this.book_id = book_id; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Integer getPublishYear() { return publishYear; }
    public void setPublishYear(Integer publishYear) { this.publishYear = publishYear; }
}
package com.library.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrows")
public class borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrow_id;

    @Column(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(name = "u_id", nullable = false)
    private Integer uId;

    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;

    @Column(nullable = false)
    private String status = "BORROWED";

    public borrow() {}

    // Getters and Setters
    public Integer getBorrow_id() { return borrow_id; }
    public void setBorrow_id(Integer borrow_id) { this.borrow_id = borrow_id; }

    public Integer getBookId() { return bookId; }
    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public Integer getuId() { return uId; }
    public void setuId(Integer uId) { this.uId = uId; }

    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
package com.library.controller;

import com.library.entity.borrow;
import com.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/borrows")
@CrossOrigin(origins = "http://localhost:3000")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public List<borrow> getAllBorrows() {
        return borrowService.getAllBorrows();
    }

    @PostMapping
    public borrow createBorrowRecord(@RequestBody borrow borrow) {
        return borrowService.saveBorrow(borrow);
    }
}
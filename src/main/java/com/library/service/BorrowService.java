package com.library.service;

import com.library.entity.borrow;
import com.library.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    public List<borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    public borrow saveBorrow(borrow borrow) {
        return borrowRepository.save(borrow);
    }
}
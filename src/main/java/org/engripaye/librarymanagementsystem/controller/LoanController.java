package org.engripaye.librarymanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.engripaye.librarymanagementsystem.dto.BorrowRequest;
import org.engripaye.librarymanagementsystem.model.Loan;
import org.engripaye.librarymanagementsystem.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
@AllArgsConstructor
public class LoanController {

    private final LoanService service;

    @PostMapping("/borrow")
    public Loan borrow(@RequestBody BorrowRequest borrowRequest){
        int days = (borrowRequest.days() == null || borrowRequest.days() <= 0) ? 14 : borrowRequest.days();
        return service.borrow(borrowRequest.userId(), borrowRequest.bookId(), days);
    }

    @PostMapping("/{loanId}/return")
    public Loan returnBook(@PathVariable Long loanId){
        return service.returnBook(loanId);
    }
}

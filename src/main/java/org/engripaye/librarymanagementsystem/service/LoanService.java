package org.engripaye.librarymanagementsystem.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.engripaye.librarymanagementsystem.model.AppUser;
import org.engripaye.librarymanagementsystem.model.Book;
import org.engripaye.librarymanagementsystem.model.Loan;
import org.engripaye.librarymanagementsystem.repository.BookRepository;
import org.engripaye.librarymanagementsystem.repository.LoanRepository;
import org.engripaye.librarymanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Loan borrow(Long userId, Long bookId, int days){
        AppUser user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();

        if(book.getAvailableCopies() == null || book.getAvailableCopies() <= 0)
            throw new IllegalStateException("No Copies Available");

        //prevent duplicate active loan for same user/book
        loanRepository.findByUserAndBookAndReturnedAtIsNull(user, book)
                .ifPresent(I -> {throw new IllegalStateException("User already borrowed this book");});


        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        return loanRepository.save(Loan.builder()
                .user(user)
                .book(book)
                .borrowedAt(LocalDate.now())
                .dueAt(LocalDate.now().plusDays(days))
                .build());

    }

    @Transactional
    public Loan returnBook(Long loanId){
        Loan loan = loanRepository.findById(loanId).orElseThrow();
        if(loan.getReturnedAt() != null) return loan;

        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        loan.setReturnedAt(LocalDate.now());
        return loanRepository.save(loan);
    }
}

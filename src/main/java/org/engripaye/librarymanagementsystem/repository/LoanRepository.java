package org.engripaye.librarymanagementsystem.repository;

import org.engripaye.librarymanagementsystem.model.AppUser;
import org.engripaye.librarymanagementsystem.model.Book;
import org.engripaye.librarymanagementsystem.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
    Optional<Loan> findByUserAndBookAndReturnedAtIsNull(AppUser user, Book book);
}

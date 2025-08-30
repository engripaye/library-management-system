package org.engripaye.librarymanagementsystem.repository;

import org.engripaye.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String id);

    List<Book> findByTitleContainingIgnoreCase(String q);
    List<Book> findByAuthorContainingIgnoreCase(String q);
}

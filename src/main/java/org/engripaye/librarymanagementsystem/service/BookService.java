package org.engripaye.librarymanagementsystem.service;

import lombok.AllArgsConstructor;
import org.engripaye.librarymanagementsystem.model.Book;
import org.engripaye.librarymanagementsystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> list(){
        return bookRepository.findAll();
    }

    public Book create(Book book){
        if(book.getAvailableCopies() == null) book.setAvailableCopies(book.getTotalCopies());
        return bookRepository.save(book);
    }

    public List<Book> search(String search){
        if(search == null || search.isBlank()) return bookRepository.findAll();
        var byTitle = bookRepository.findByTitleContainingIgnoreCase(search);
        var byAuthor = bookRepository.findByTitleContainingIgnoreCase(search);
        byAuthor.stream().filter(book -> !byTitle.contains(book)).forEach(byTitle::add);
        return byTitle;
    }

    public Book get(Long id){
        return bookRepository.findById(id).orElseThrow();
    }

}

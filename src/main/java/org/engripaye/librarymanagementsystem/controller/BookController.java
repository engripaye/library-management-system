package org.engripaye.librarymanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.engripaye.librarymanagementsystem.model.Book;
import org.engripaye.librarymanagementsystem.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService service;


    @GetMapping
    public List<Book> list() {
        return service.list();
    }

    @PostMapping
    public Book create(@Valid @RequestBody Book book) {
        return service.create(book);
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam(required = false) String search){
        return service.search(search);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id){
        return service.get(id);
    }
}

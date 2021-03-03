package com.zemoso.aopdemo.controller;


import com.zemoso.aopdemo.dto.BookDto;
import com.zemoso.aopdemo.exception.BookNotFoundException;
import com.zemoso.aopdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public List<BookDto> getBook() {

        return bookService.getBook();
    }

    @PostMapping()
    public BookDto addBook(@RequestBody(required = true) BookDto book) {
        return bookService.addBook(book);
    }

    @PutMapping
    public ResponseEntity<String> updateBook( @RequestBody(required = false) BookDto book) {
        bookService.updateBook(book);
//        throw new BookNotFoundException("book not found");
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@RequestParam UUID id) {
         bookService.deleteBook(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}

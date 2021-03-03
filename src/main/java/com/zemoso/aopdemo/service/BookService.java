package com.zemoso.aopdemo.service;

import com.zemoso.aopdemo.dao.BookRepository;
import com.zemoso.aopdemo.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getBook() {
        return bookRepository.getBook();
    }

    public BookDto addBook(BookDto book) {
        return bookRepository.addBook(book);
    }

    public void updateBook(BookDto book) {
        bookRepository.updateBook(book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteBook(id);
    }
}

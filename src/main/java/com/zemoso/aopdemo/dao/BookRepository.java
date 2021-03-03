package com.zemoso.aopdemo.dao;

import com.zemoso.aopdemo.dto.BookDto;
import com.zemoso.aopdemo.dto.mapper.BookDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BookDto> getBook() {
        String sql = "select * from books";
        List<BookDto> customers = jdbcTemplate.query(sql, new BookDTOMapper());
        return customers;
    }

    public BookDto addBook(BookDto book) {
        String sqlInsertQuery = "INSERT INTO books VALUES (?,?, ?, ?, ?)";
            jdbcTemplate.update(sqlInsertQuery, book.getId(),book.getTitle(),book.getIsbn(),book.getDescription(),book.getNoPages());
            return book;
    }

    public void updateBook(BookDto book) {
        String sqlUpdateQuery = "UPDATE books set title=? where id=?";
        jdbcTemplate.update(sqlUpdateQuery, book.getTitle(), book.getId());
    }

    public void deleteBook(UUID id) {
        String sqlDeleteQuery = "DELETE FROM books where id=?";
        jdbcTemplate.update(sqlDeleteQuery, id);
    }
}

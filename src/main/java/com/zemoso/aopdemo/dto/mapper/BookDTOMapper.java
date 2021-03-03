package com.zemoso.aopdemo.dto.mapper;

import com.zemoso.aopdemo.dto.BookDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BookDTOMapper implements RowMapper<BookDto> {
    @Override
    public BookDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        BookDto book = new BookDto();
        book.setId(resultSet.getObject(1, UUID.class));
        book.setTitle(resultSet.getString(2));
        book.setIsbn(resultSet.getString(3));
        book.setDescription(resultSet.getString(4));
        book.setNoPages(resultSet.getInt(5));
        return book;
    }
}

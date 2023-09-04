package com.macon_library_test.dao;

import com.macon_library_test.model.Book;
import com.macon_library_test.utul.SearchBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update(
                "INSERT INTO book(title, author, type, segment, year) " +
                        "VALUES(?, ?, ?, ?, ?)", book.getTitle(), book.getAuthor(), book.getType(), book.getSegment(),
                book.getYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET title=?, author=?, type=?, segment=?, year=? WHERE id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getType(), updatedBook.getSegment(),
                updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }

    public List<Book> find(SearchBook searchBook) {
        List<Book> result = jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));

        if (!searchBook.getTitle().equals("")) {
            result = result.stream().filter(b -> b.getTitle().equals(searchBook.getTitle())).collect(Collectors.toList());
        }
        if (!searchBook.getAuthor().equals("")) {
            result = result.stream().filter(b -> b.getAuthor().equals(searchBook.getAuthor())).collect(Collectors.toList());
        }
        if (!searchBook.getType().equals("")) {
            result = result.stream().filter(b -> b.getType().equals(searchBook.getType())).collect(Collectors.toList());
        }
        if (!searchBook.getSegment().equals("")) {
            result = result.stream().filter(b -> b.getSegment().equals(searchBook.getSegment())).collect(Collectors.toList());
        }
        if (!searchBook.getYear().equals("")) {
            result = result.stream().filter(b -> b.getYear() == Integer.parseInt(searchBook.getYear())).collect(Collectors.toList());
        }

        return result;
    }
}

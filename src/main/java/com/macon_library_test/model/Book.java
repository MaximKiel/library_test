package com.macon_library_test.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 200, message = "Title should be between 2 and 200 characters")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max = 100, message = "Author should be between 2 and 100 characters")
    private String author;

    @NotEmpty(message = "Type should not be empty")
    @Size(min = 2, max = 100, message = "Type should be between 2 and 100 characters")
    private String type;

    @NotEmpty(message = "Segment should not be empty")
    @Size(min = 2, max = 100, message = "Segment should be between 2 and 100 characters")
    private String segment;

    @NotNull(message = "Year should not be null")
    @Min(value = 1900, message = "Year should be more than 1900")
    private int year;

    public Book() {
    }

    public Book(int id, String title, String author, String type, String segment, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.segment = segment;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

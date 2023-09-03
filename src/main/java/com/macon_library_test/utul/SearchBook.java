package com.macon_library_test.utul;

public class SearchBook {

    private String title;
    private String author;
    private String type;
    private String segment;
    private String year;

    public SearchBook() {
    }

    public SearchBook(String title, String author, String type, String segment, String year) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.segment = segment;
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

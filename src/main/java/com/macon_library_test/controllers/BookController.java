package com.macon_library_test.controllers;

import com.macon_library_test.dao.BookDAO;
import com.macon_library_test.model.Book;
import com.macon_library_test.utul.SearchBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/library/books")
public class BookController {

    private final BookDAO bookDAO;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "library/books/index";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("book") SearchBook book) {
        return "library/books/search";
    }

    @PostMapping("/search-result")
    public String searchResult(Model model, @ModelAttribute("book") @Valid SearchBook book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "library/books/search";
        }
        model.addAttribute("result", bookDAO.find(book));
        return "library/books/result";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "library/books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book")Book book) {
        return "library/books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "library/books/new";
        }

        bookDAO.save(book);
        return "redirect:/library/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.show(id));
        return "library/books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "library/books/edit";
        }

        bookDAO.update(id, book);
        return "redirect:/library/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/library/books";
    }
}

package com.macon_library_test.controllers;

import com.macon_library_test.dao.MaconProjectDAO;
import com.macon_library_test.model.MaconProject;
import com.macon_library_test.validator.MaconProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/library")
public class MaconProjectController {

    private final MaconProjectDAO maconProjectDAO;
    private final MaconProjectValidator validator;

    @Autowired
    public MaconProjectController(MaconProjectDAO maconProjectDAO, MaconProjectValidator validator) {
        this.maconProjectDAO = maconProjectDAO;
        this.validator = validator;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("project", maconProjectDAO.index());
        return "library/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("project", maconProjectDAO.show(id));
        return "library/show";
    }

    @GetMapping("/new")
    public String newProject(@ModelAttribute("project") MaconProject project) {
        return "library/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("project") @Valid MaconProject project, BindingResult bindingResult) {

        validator.validate(project, bindingResult);

        if (bindingResult.hasErrors()) {
            return "library/new";
        }

        maconProjectDAO.save(project);
        return "redirect:/library";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("project", maconProjectDAO.show(id));
        return "library/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("project") @Valid MaconProject project,
                         BindingResult bindingResult) {
        validator.validate(project, bindingResult);

        if(bindingResult.hasErrors()) {
            return "library/edit";
        }

        maconProjectDAO.update(id, project);
        return "redirect:/library";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        maconProjectDAO.delete(id);
        return "redirect:/library";
    }
}

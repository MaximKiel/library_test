package com.macon_library_test.controllers;

import com.macon_library_test.dao.MaconProjectDAO;
import com.macon_library_test.model.MaconProject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/library")
public class MaconProjectController {

    private final MaconProjectDAO maconProjectDAO;

    public MaconProjectController(MaconProjectDAO maconProjectDAO) {
        this.maconProjectDAO = maconProjectDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("projects", maconProjectDAO.index());
        return "library/index";
    }

    @GetMapping("/search")
    public String search(Model model) {
        HashMap<String, String> searchSettings = initSearchSettings();
        model.addAttribute("projectMap", searchSettings);
        return "library/search";
    }
    @PostMapping("/search-result")
    public String searchResult() {
        return "redirect:/library";
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

        if (bindingResult.hasErrors()) {
            return "library/new";
        }

        maconProjectDAO.save(project);
        return "redirect:/library";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("project", maconProjectDAO.show(id));
        return "library/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("project") @Valid MaconProject project, BindingResult bindingResult,
                         @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
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

    private HashMap<String, String> initSearchSettings() {
        HashMap<String, String> searchSettings = new HashMap<>();
        searchSettings.put("number", null);
        searchSettings.put("title", null);
        searchSettings.put("country", null);
        searchSettings.put("region", null);
        searchSettings.put("city", null);
        searchSettings.put("client", null);
        searchSettings.put("segment", null);
        searchSettings.put("type", null);
        searchSettings.put("period", null);
        return searchSettings;
    }
}

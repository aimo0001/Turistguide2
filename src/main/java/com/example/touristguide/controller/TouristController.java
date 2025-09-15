package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService service;
    public TouristController(TouristService service) {this.service= service;}

    @GetMapping
    public String list(Model model){
        model.addAttribute("items", service.all());
        return "attractionList";
    }

    @GetMapping("/{name}/tags")
    public String tags(@PathVariable("name") String name, Model model){
        model.addAttribute("item", service.one(name).orElse(null));
        return "tags";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("item",new TouristAttraction());
        model.addAttribute("cities", service.cities());
        model.addAttribute("allTags", service.tagCatalog());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("item") TouristAttraction a ) {
        service.save(a);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/edit")
    public String editForm(@PathVariable("name") String name, Model model){
        model.addAttribute("item", service.one(name).orElse(null));
        model.addAttribute("cities", service.cities());
        model.addAttribute("allTags", service.tagCatalog());
        return "updateAttraction";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("item") TouristAttraction a ) {
        service.save(a);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/delete")
    public String delete(@PathVariable("name") String name) {
        service.remove(name);
        return "redirect:/attractions";
    }

}

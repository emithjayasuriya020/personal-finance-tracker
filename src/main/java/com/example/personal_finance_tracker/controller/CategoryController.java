package com.example.personal_finance_tracker.controller;

import com.example.personal_finance_tracker.model.Category;
import com.example.personal_finance_tracker.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        // Add an empty Category object for form binding
        model.addAttribute("category", new Category());

        return "categories";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model) {
        // Retrieve the category to be edited
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories";  // Renders the same category management page but with category data pre-filled
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}

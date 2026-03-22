package com.example.personal_finance_tracker.controller;

import com.example.personal_finance_tracker.model.Category;
import com.example.personal_finance_tracker.model.Transaction;
import com.example.personal_finance_tracker.model.TransactionType;
import com.example.personal_finance_tracker.service.CategoryService;
import com.example.personal_finance_tracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryService categoryService;

    // Display the list of transactions
    @GetMapping
    public String viewTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    // Show form to add a new transaction
    @GetMapping("/new")
    public String showNewTransactionForm(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "transaction_form";
    }

    // Save a new transaction
    @PostMapping("/save")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }

    // Show the update form for a specific transaction
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Transaction transaction = transactionService.getTransactionById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid transaction Id: " + id));
        model.addAttribute("transaction", transaction);
        return "transaction_form";
    }

    // Fetch categories by transaction type
    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getCategoriesByType(@RequestParam("type") TransactionType type) {
        return categoryService.getCategoriesByType(type);
    }

    // Delete a transaction
    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }
}
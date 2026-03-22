package com.example.personal_finance_tracker.controller;

import com.example.personal_finance_tracker.model.Transaction;
import com.example.personal_finance_tracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Fetch total income and expenses
        BigDecimal totalIncome = transactionService.getTotalIncome();
        BigDecimal totalExpenses = transactionService.getTotalExpenses();

        // Fetch recent transactions (let's say top 5)
        List<Transaction> recentTransactions = transactionService.getRecentTransactions(5);

        // Add attributes to the model
        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpenses", totalExpenses);
        model.addAttribute("recentTransactions", recentTransactions);

        return "dashboard"; // This should match the Thymeleaf template name dashboard.html
    }
}

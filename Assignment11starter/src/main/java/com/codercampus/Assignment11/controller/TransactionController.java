package com.codercampus.Assignment11.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        List<Transaction> transactions = transactionRepository.findAll();
        model.addAttribute("transactions", transactions);
        return "transactions"; // Ensure this matches your HTML file without the .html extension
    }

    @GetMapping("transactions/{transactionId}")
    public String getTransaction(@PathVariable Long transactionId, ModelMap model) {
        // Since you don't have a detail page, this line should be handled or removed if not needed.
        // If you want to show details on the same page, consider modifying your template accordingly.
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
        model.addAttribute("transaction", transaction);
        // If you don't have a dedicated detail page, you might need to handle it differently.
        return "transactions"; // Make sure this page can handle both listings and detail display
    }
}

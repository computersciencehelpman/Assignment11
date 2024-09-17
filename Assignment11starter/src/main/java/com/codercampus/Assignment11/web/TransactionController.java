package com.codercampus.Assignment11.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

  
   
    private final TransactionService transactionService;

   
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        List<Transaction> transactions = transactionService.findAllAndSort();
        model.addAttribute("transactions", transactions);
        return "transactions"; 
    }

    @GetMapping("transactions/{transactionId}")
    public String getTransaction(@PathVariable Long transactionId, ModelMap model) {
       try {
    	   Transaction transaction = transactionService.findById(transactionId);
           model.addAttribute("transaction", transaction);
       }
       catch (IndexOutOfBoundsException e) {
    	   model.addAttribute("errorMessage", e.getMessage());
       }
    	
        return "transactionDetails"; 
    }
}

package com.codercampus.Assignment11.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@RestController
public class TestController {

	private static TransactionRepository transactionReopsitory;
	
	public TestController(TransactionRepository transactionRepository) {
		TestController.transactionReopsitory = transactionRepository;
	}
	
	@GetMapping("/test-endpoint")
	public List<Transaction> testTransactions(){
		return transactionReopsitory.findAll();
	}
	
}

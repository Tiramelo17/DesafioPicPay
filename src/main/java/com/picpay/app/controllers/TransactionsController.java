package com.picpay.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.app.appService.TransactionsAppService;
import com.picpay.app.models.Transaction;
import com.picpay.app.models.TransactionModel;
import com.picpay.app.models.UserModel;
import com.picpay.app.response.TransactionResponse;
import com.picpay.app.services.TransactionService;

@RestController()
@RequestMapping("/transaction")
public class TransactionsController {

	@Autowired
	TransactionsAppService transactionAppService;
	
	@Autowired
	TransactionService transactionService;

	/*
	@PostMapping("/{cpfCnpj}")
	public ResponseEntity<Object> realizarTransacaoFuturo(@PathVariable(value="cpfCnpj") String cpfCnpj, @RequestBody Transaction transaction){
		 return  ResponseEntity.status(HttpStatus.CREATED).body(transactionAppService.processarTrasaction(cpfCnpj,transaction));
	}
	
	@PostMapping
	public ResponseEntity<Object> realizarTransacao(@RequestBody TransactionModel transaction){
		return  ResponseEntity.status(HttpStatus.CREATED).body(transactionService.save(transaction));
	}
	 */
	
	
	@PostMapping
	public ResponseEntity<Object> realizarTransacao(@RequestBody Transaction transaction){
		
		TransactionResponse transactionResponse = transactionAppService.processarTrasaction(transaction);
		if(transactionResponse.getCodReponse() == 500) {
			 ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(transactionResponse);
		}
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<Object> findAllUsers() {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(transactionService.findAll());
	}
	

}

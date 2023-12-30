package com.picpay.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpay.app.models.TransactionModel;
import com.picpay.app.repositories.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Transactional
	public TransactionModel save(TransactionModel transaction) {
		return this.transactionRepository.save(transaction);
	}

	public List<TransactionModel> findAll() {
		return this.transactionRepository.findAll();

	}
}


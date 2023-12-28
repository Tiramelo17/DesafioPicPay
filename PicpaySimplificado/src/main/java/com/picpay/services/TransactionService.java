package com.picpay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picpay.models.TransactionModel;
import com.picpay.repository.TransactionRepository;

@Service
public class TransactionService {
	
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Transactional
	public TransactionModel save(TransactionModel transaction) {
		return this.transactionRepository.save(transaction);
	}
}

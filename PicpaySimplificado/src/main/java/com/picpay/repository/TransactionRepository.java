package com.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.models.TransactionModel;

public interface TransactionRepository extends JpaRepository<TransactionModel,Integer>{

}

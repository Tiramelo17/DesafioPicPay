package com.picpay.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.app.models.TransactionModel;

public interface TransactionRepository extends JpaRepository<TransactionModel,Integer>{

}

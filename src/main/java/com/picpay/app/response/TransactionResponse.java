package com.picpay.app.response;

import com.picpay.app.models.TransactionModel;

public class TransactionResponse {
	
	private Integer codReponse;
	private String message;
	private TransactionModel transactionModel;
	
	
	public Integer getCodReponse() {
		return codReponse;
	}
	public void setCodReponse(Integer codReponse) {
		this.codReponse = codReponse;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TransactionModel getTransactionModel() {
		return transactionModel;
	}
	public void setTransactionModel(TransactionModel transactionModel) {
		this.transactionModel = transactionModel;
	}
	public TransactionResponse(Integer codReponse, String message, TransactionModel transactionModel) {
		super();
		this.codReponse = codReponse;
		this.message = message;
		this.transactionModel = transactionModel;
	}
	public TransactionResponse() {
		super();
	}
	
	
	
}

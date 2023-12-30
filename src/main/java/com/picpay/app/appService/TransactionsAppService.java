package com.picpay.app.appService;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.picpay.app.enumerators.UserTypeEnum;
import com.picpay.app.models.Transaction;
import com.picpay.app.models.TransactionModel;
import com.picpay.app.models.UserModel;
import com.picpay.app.response.TransactionResponse;
import com.picpay.app.services.TransactionService;


@Component
public class TransactionsAppService {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	UsersAppService usersAppService;
	
	
	private final RestTemplate restTemplate;

	public TransactionsAppService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public TransactionResponse processarTrasaction(Transaction transaction) {
		
		UserModel userPayer = usersAppService.findUserForTransaction(transaction.getPayer()); 
		UserModel userPayee = usersAppService.findUserForTransaction(transaction.getPayee()); 
		
		TransactionResponse responseTransaction = new TransactionResponse();
		try {
			valideteUserForTransaction(transaction.getValor(), userPayer);
			validateTransaction();
			TransactionModel transactionModel = new TransactionModel(userPayer, userPayee,
					transaction.getValor(), new Date());
		
			usersAppService.processBalanceForUsers(transaction.getValor(), userPayer, userPayee);
		    transactionService.save(transactionModel);
		    responseTransaction.setCodReponse(201);
		    responseTransaction.setMessage("Sucesso");
		    responseTransaction.setTransactionModel(transactionModel);
			
		} catch (Exception e) {
			
			return new TransactionResponse(500,e.getMessage(),null);
		}
		return responseTransaction;
				
		
	}
	
	
	
	private void valideteUserForTransaction(Double value, UserModel userPayer) throws Exception {
				
		if(userPayer.getSaldo() < value) {
			throw new Exception("Saldo do pagador menor que o valor da transafencia");
		}
		
		if(userPayer.getUserType().equals(UserTypeEnum.LOJISTA)) {
			throw new Exception("O tipo de Usuário LOJISTA não tem permisão para realizar pagamentos");
		}
		
		
	}
	
	private void validateTransaction() throws Exception {
		ResponseEntity<Map> authorizationReponse= restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
		
		if(authorizationReponse.getStatusCode() != HttpStatus.OK && authorizationReponse.getBody().get("message").equals("Autorizado")) {
			return;
		}
		
		throw new Exception(authorizationReponse.getStatusCode() + " - " + authorizationReponse.getBody().toString());
	
	}
	
	
	private void sendMessageReceiver(TransactionModel transactionModel) {
		try {
			ResponseEntity<Map> serndMEssageReponse= restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6",transactionModel, Map.class);			
		} catch(RestClientException e) {
			
		}
		
		// Possivelmente criar aqui um logger para monitoramento do envio dessas mensagens, caso tenha algum problema
		// mas não é um impeditivo para realizar a transação
	}
	
}

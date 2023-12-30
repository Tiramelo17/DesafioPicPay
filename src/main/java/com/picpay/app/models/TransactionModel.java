package com.picpay.app.models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode 
public class TransactionModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTransaction;
	
	
	@ManyToOne
	@JoinColumn(name="payer_id")
	private UserModel payer;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private UserModel receiver;
	
	@Column
	private Double valor;
	
	@Column
	private Date timestamp;

	public TransactionModel(UserModel payer, UserModel receiver, Double valor,
			Date timestamp) {
		super();
		this.payer = payer;
		this.receiver = receiver;
		this.valor = valor;
		this.timestamp = timestamp;
	}
	
	
	public TransactionModel() {}


	public Integer getIdTransaction() {
		return idTransaction;
	}


	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}


	public UserModel getPayer() {
		return payer;
	}


	public void setPayer(UserModel payer) {
		this.payer = payer;
	}


	public UserModel getReceiver() {
		return receiver;
	}


	public void setReceiver(UserModel receiver) {
		this.receiver = receiver;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}

package com.picpay.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	
	
	@OneToOne
	private UserModel payer;
	
	@OneToOne
	private UserModel receiver;
	
	
	private Double Value;
	
	

}

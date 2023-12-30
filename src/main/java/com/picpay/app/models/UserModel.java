package com.picpay.app.models;

import java.io.Serializable;

import com.picpay.app.enumerators.UserTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode 
public class UserModel  implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;	
	
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String cpfCnpj;
	
	private String senha;
	
	
	private Double saldo;
	
	@Enumerated(EnumType.STRING)
	private UserTypeEnum userType;


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public UserTypeEnum getUserType() {
		return userType;
	}
	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}
	
	
}

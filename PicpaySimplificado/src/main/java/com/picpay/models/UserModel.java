package com.picpay.models;

import java.io.Serializable;

import com.picpay.enumerators.UserTypeEnum;

import jakarta.persistence.*;
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
	private Integer codUser;	
	
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String cpfCnpj;
	
	private String senha;
	
	
	private Double saldo;
	
	@Enumerated(EnumType.STRING)
	private UserTypeEnum userType;
	
}

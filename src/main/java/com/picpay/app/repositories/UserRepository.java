package com.picpay.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.app.models.UserModel;

public interface UserRepository  extends JpaRepository<UserModel, Integer> {

	Optional<UserModel> findUserByCpfCnpj(String cpfCnpj);
	
	Optional<UserModel> findUserByUserId(Integer userId);
}

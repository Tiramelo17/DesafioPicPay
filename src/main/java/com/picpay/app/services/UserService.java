package com.picpay.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpay.app.models.UserModel;
import com.picpay.app.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public UserModel saveUser(UserModel user) {
		return this.userRepository.save(user);
	}
	
	@Transactional
	public List<UserModel> findAll() {
		return this.userRepository.findAll();
	}
	
	@Transactional
	public Optional<UserModel> findUserByCpfCnpj(String cpfCnpj) {
		return this.userRepository.findUserByCpfCnpj(cpfCnpj);
	}
	
	@Transactional
	public Optional<UserModel> findUserByUserId(Integer userId) {
		return this.userRepository.findUserByUserId(userId);
	}
	
	@Transactional
	public UserModel update(UserModel user) {
		return this.userRepository.save(user);
	}
	
	
	@Transactional
	public List<UserModel> updateList(List<UserModel> users) {
		return this.userRepository.saveAll(users);
	}
}

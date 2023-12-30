package com.picpay.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.app.models.UserModel;
import com.picpay.app.services.UserService;


@RestController()
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<Object> creationUser(@RequestBody UserModel user){
		return  ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}
	

	@GetMapping
	public ResponseEntity<Object> findAllUsers() {
		List<UserModel> listUsers = userService.findAll();
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(listUsers);
	}
	
}

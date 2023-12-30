package com.picpay.app.appService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.picpay.app.models.UserModel;
import com.picpay.app.services.UserService;

@Component
public class UsersAppService {

	@Autowired
	UserService userService;
	
	public UserModel findUserForTransaction(Integer userId) {
		
		Optional<UserModel> userOptional = userService.findUserByUserId(userId);

		
		return userOptional.get();
	}
	
	
	public void processBalanceForUsers(Double value, UserModel userPayer,UserModel userPayee) {

		userPayer.setSaldo(userPayer.getSaldo() - value);
		userPayee.setSaldo(userPayee.getSaldo() + value);
		
		List<UserModel> listUpdate = new ArrayList<>();
		listUpdate.add(userPayer);
		listUpdate.add(userPayee);
		
		userService.updateList(listUpdate);
	}
	
}

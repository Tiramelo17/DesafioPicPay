package com.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay.models.UserModel;

public interface UserRepository  extends JpaRepository<UserModel, Integer> {

}

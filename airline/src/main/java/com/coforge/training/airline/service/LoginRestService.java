package com.coforge.training.airline.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.training.airline.model.User;
import com.coforge.training.airline.repository.UserRepository;


@Service
@Transactional
public class LoginRestService {
	
	@Autowired
	private UserRepository urepo;
	
	public User registerUser(User user) {
		return urepo.save(user);
	}
	
	@Autowired
	public List<User> getAllUser(){
		return urepo.findAll();
	}
	
	public Optional<User> loginUser(String email)
	{
		return urepo.findByEmail(email);
	}
}

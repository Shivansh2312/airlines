package com.coforge.training.airline.restController;

import java.nio.charset.StandardCharsets;

import java.util.Base64;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.airline.exception.ResourceNotFoundException;
import com.coforge.training.airline.model.Admin;
import com.coforge.training.airline.model.User;
import com.coforge.training.airline.service.LoginRestService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class LoginRestController {

	@Autowired
	private LoginRestService lrservice;

	//Open Postman and make POST request - http://localhost:8085/airline/api/passenger
	//Under body tab --> raw --> Text --> Json and type the json data to be saved
	@PostMapping("/register_users")
	public User createPassenger(@Validated @RequestBody User user) {
		User u = new User();
		u.setTitle(user.getTitle());
		u.setFname(user.getFname());
		u.setLname(user.getLname());
		u.setEmail(user.getEmail());
		u.setPass(user.getPass());
		u.setDob(user.getDob());
		u.setCpass(user.getCpass());
		u.setContactNo(user.getContactNo());

		u = lrservice.registerUser(u);
		return user;
	}

	//Open Postman and make GET request - http://localhost:8085/airline/api/register_users
	@GetMapping("/register_users")
	public List<User> getAllUser(){
		return lrservice.getAllUser();
	}

	//Open Postman and make POST request - http://localhost:8085/airline/api/login_user
	
	// Note: Have to change the return type to Boolean and return variable 'a';
	@PostMapping("/login_user")
	public Boolean loginUser(@Validated @RequestBody User user) throws ResourceNotFoundException
	{
		Boolean a=false;

		String email = user.getEmail();
		String password = user.getPass();
		System.out.println("the password of passenger is: "+user.getPass());
		
		User u = lrservice.loginUser(email).orElseThrow(() ->
		new ResourceNotFoundException("User not found for this id :: "));
		System.out.println(u.getEmail() +" "+ u.getPass());

		if(email.equals(u.getEmail()) && password.equals(u.getPass()))
		{
			a=true;
		}
		return a;
//		if(a==true)
//			return "Login Successful!";
//		else
//			return "Invalid Password";
	}
	
	@PostMapping("/admin_login")
	public Boolean adminLogin(@Validated @RequestBody Admin adm) throws ResourceNotFoundException
	{
		Boolean a = false;
		String admin_email = "srishiv@gmail.com";
		String admin_pass = "shiv54";

		
		String email = adm.getAdmin_email();
		String pass = adm.getAdmin_pass();
		System.out.println("Email:  "+email);
		System.out.println("Password:  "+pass);
		if((admin_email.equals(email)) && admin_pass.equals(pass))
		{
			a = true;
		}
		return a;
//		if(a==true)
//			return "Admin Login Successful!";
//		else
//			return "Invalid Fields";
	}


}

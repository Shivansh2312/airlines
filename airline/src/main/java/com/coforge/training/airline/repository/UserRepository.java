package com.coforge.training.airline.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coforge.training.airline.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);


}
   
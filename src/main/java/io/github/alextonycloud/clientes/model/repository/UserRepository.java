package io.github.alextonycloud.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.alextonycloud.clientes.model.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	UserDetails findByLogin(String login);

	boolean existsByLogin(String login);
	
	
}

package io.github.alextonycloud.clientes.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.alextonycloud.clientes.model.entity.User;
import io.github.alextonycloud.clientes.model.repository.UserRepository;
import io.github.alextonycloud.clientes.restcontroller.exceptions.UserRegisteredException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByLogin(username);
	}
	
	public User save(User user) {
		boolean exists = userRepository.existsByLogin(user.getLogin());
		if(exists) throw new UserRegisteredException(user.getLogin());
		
		return userRepository.save(user);
	}	

}

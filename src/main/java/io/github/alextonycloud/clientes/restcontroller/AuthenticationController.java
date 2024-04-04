package io.github.alextonycloud.clientes.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.alextonycloud.clientes.model.entity.User;
import io.github.alextonycloud.clientes.restcontroller.dto.AuthenticationDTO;
import io.github.alextonycloud.clientes.restcontroller.dto.LoginResponseDTO;
import io.github.alextonycloud.clientes.restcontroller.dto.RegisterDTO;
import io.github.alextonycloud.clientes.restcontroller.exceptions.UserRegisteredException;
import io.github.alextonycloud.clientes.service.AuthorizationService;
import io.github.alextonycloud.clientes.service.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final AuthorizationService authorizationService;
	private final TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data){
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((User) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponseDTO(usernamePassword.getName(), token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
		try {
			String encryptedPassaword = new BCryptPasswordEncoder().encode(data.password());
			User newUser = new User(data.login(), encryptedPassaword, data.role());
			this.authorizationService.save(newUser);
			return ResponseEntity.ok().build();
			
		}catch (UserRegisteredException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}

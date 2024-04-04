package io.github.alextonycloud.clientes.restcontroller.exceptions;

public class UserRegisteredException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserRegisteredException(String login) {
		super("Usuário já cadastrado para o login " + login);
	}

}

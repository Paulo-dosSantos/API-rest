package br.com.testes.api_rest.services;

import br.com.testes.api_rest.entities.User;

public interface UserService {
	
	User findById(Integer id);

}

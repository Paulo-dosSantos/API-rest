package br.com.testes.api_rest.services;

import java.util.List;

import br.com.testes.api_rest.entities.User;

public interface UserService {
	
	User findById(Integer id);
	
	List<User>findAll();

}

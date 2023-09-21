package br.com.testes.api_rest.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testes.api_rest.entities.User;
import br.com.testes.api_rest.repositories.UserRepository;
import br.com.testes.api_rest.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Integer id) {
		Optional <User> user= repository.findById(id);
		
		return user.get();
	}

}

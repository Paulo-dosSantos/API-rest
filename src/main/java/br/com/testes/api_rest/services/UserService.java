package br.com.testes.api_rest.services;

import java.util.List;

import br.com.testes.api_rest.entities.User;
import br.com.testes.api_rest.entities.dto.UserDTO;

public interface UserService {
	
	User findById(Integer id);
	
	List<User>findAll();
	
	User create(UserDTO obj);
	
	User update(UserDTO obj);

}

package br.com.testes.api_rest.resources;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testes.api_rest.entities.User;
import br.com.testes.api_rest.entities.dto.UserDTO;
import br.com.testes.api_rest.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO>findById(@PathVariable Integer id){
		User user= service.findById(id);
		
		return ResponseEntity.ok().body(modelMapper.map(user, UserDTO.class));
	}

}

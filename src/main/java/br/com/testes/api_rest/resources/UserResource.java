package br.com.testes.api_rest.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testes.api_rest.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User>findById(@PathVariable Integer id){
		User user= new User(id, "Matt Murdock", "nelson.e.murdock@gmail.com", "hells_kitchen")	;
		return ResponseEntity.ok().body(user);
	}

}

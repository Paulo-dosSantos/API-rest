package br.com.testes.api_rest.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll(){
		
		List<UserDTO>listDTO= service.findAll().stream().map(x->modelMapper.map(x, UserDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	@PostMapping
	public ResponseEntity<UserDTO>create(@RequestBody UserDTO obj){
		User newObj=service.create(obj);
		URI uri= ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}

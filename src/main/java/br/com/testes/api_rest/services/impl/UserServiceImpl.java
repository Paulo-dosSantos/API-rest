package br.com.testes.api_rest.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testes.api_rest.entities.User;
import br.com.testes.api_rest.entities.dto.UserDTO;
import br.com.testes.api_rest.repositories.UserRepository;
import br.com.testes.api_rest.services.UserService;
import br.com.testes.api_rest.services.exceptions.DataIntegratyViolationException;
import br.com.testes.api_rest.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public User findById(Integer id) {
		Optional <User> user= repository.findById(id);
		
		return user.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
	}
	public List<User>findAll(){
		List<User>users= repository.findAll();
		
		return users;
	}
	@Override
	public User create(UserDTO obj) {
		findByEmail(obj);
		return repository.save(mapper.map(obj, User.class));
	}
	private void findByEmail(UserDTO obj) {
		Optional<User>user=repository.findByEmail(obj.getEmail());
		if(user.isPresent()&& user.get().getId().equals(obj.getEmail())) {
			throw new DataIntegratyViolationException("Este e-mail já está cadastrado no sistema");
			
		}
	}
	@Override
	public User update(UserDTO obj) {
		findByEmail(obj);
		User entity= repository.getReferenceById(obj.getId());
		updateData(entity,obj);
		
		return repository.save(entity);
		
	}
	private void updateData(User entity, UserDTO obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		
	}
	@Override
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
		
	}

}

package br.com.testes.api_rest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.testes.api_rest.entities.User;
import br.com.testes.api_rest.repositories.UserRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository repository;
	
	@Bean
	public void startDB() {
		User user1= new User(null, "Valdir", 
				"valdir@gmail.com"	,"123");
		
		User user2= new User(null, "Luiz", "luiz@gmail.com", "123");
	
		repository.saveAll(Arrays.asList(user1,user2));
		
		
	}


}

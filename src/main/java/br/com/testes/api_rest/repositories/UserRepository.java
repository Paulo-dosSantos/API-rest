package br.com.testes.api_rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testes.api_rest.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

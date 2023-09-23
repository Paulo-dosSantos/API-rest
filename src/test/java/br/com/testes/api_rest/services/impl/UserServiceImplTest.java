package br.com.testes.api_rest.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.testes.api_rest.entities.User;
import br.com.testes.api_rest.entities.dto.UserDTO;
import br.com.testes.api_rest.repositories.UserRepository;
import br.com.testes.api_rest.services.exceptions.DataIntegratyViolationException;
import br.com.testes.api_rest.services.exceptions.ObjectNotFoundException;

@SpringBootTest
class UserServiceImplTest {
	
	private static final String EMAIL_JA_CADASTRADO = "Este e-mail já está cadastrado no sistema";

	private static final String EXCECAO = "Objeto não encontrado";

	private static final String PASSWORD = "poscrise";

	private static final String EMAIL = "coringuete@gmail.com";

	private static final String NAME = "Bruce Wayne";

	private static final Integer ID = 1;
	
	private static final String NAME2 = "John Constantine";
	private static final String EMAIL2 = "constantine@gmail.com";
	private static final String PASSWORD2 = "vertigo@gmail.com";
	
	

	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private UserRepository repository;
	
	@Mock
	private ModelMapper mapper;
	
	private User user;
	private UserDTO userDTO;
	
	private User user2;
	
	private Optional<User>optionalUser;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void testFindById() {
		when(repository.findById(anyInt())).thenReturn(optionalUser);
		
		User response= service.findById(ID);
		assertNotNull(response);
		assertEquals(User.class, response.getClass());
		assertEquals(ID, response.getId());
		assertEquals(ID, response.getId());
		assertEquals(ID, response.getId());
		assertEquals(ID, response.getId());
		assertEquals(ID, response.getId());
		
	}


	@Test
	void testFindAll() {
		when(repository.findAll()).thenReturn(List.of(user));
		List<User>response=service.findAll();
		assertNotNull(response);
		assertEquals(1,response.size());
		assertEquals(User.class,response.get(0).getClass());
		
		assertEquals(ID, response.get(0).getId());
		assertEquals(NAME, response.get(0).getName());
		assertEquals(PASSWORD, response.get(0).getPassword());
		assertEquals(EMAIL, response.get(0).getEmail());
		
	}

	@Test
	void testCreate() {
		when(repository.save(any())).thenReturn(user);
		User response=service.create(userDTO);
		
		assertNotNull(response);
		assertEquals(User.class,response.getClass());
		assertEquals(ID,response.getId());
		assertEquals(NAME,response.getName());
		assertEquals(EMAIL,response.getEmail());
		assertEquals(PASSWORD,response.getPassword());
		
	}
	@Test
	void testCreateIntegratyViolationException() {
		when(repository.findByEmail(anyString())).thenReturn(optionalUser);
		
		try {
			optionalUser.get().setId(2);
			service.create(userDTO);
			
		}      
		catch(Exception ex) {
			assertEquals(DataIntegratyViolationException.class,ex.getClass());
			assertEquals(EMAIL_JA_CADASTRADO,ex.getMessage());
			
		}
	
		
	}

	@Test
	void testUpdate() {
		when(repository.save(any())).thenReturn(user);
		User response=service.update(userDTO);
		
		assertNotNull(response);
		assertEquals(User.class,response.getClass());
		assertEquals(ID,response.getId());
		assertEquals(NAME,response.getName());
		assertEquals(EMAIL,response.getEmail());
		assertEquals(PASSWORD,response.getPassword());
		
		
	}

	@Test
	void testDelete() {
		
		when(repository.findById(anyInt())).thenReturn(optionalUser);
		doNothing().when(repository).deleteById(ID);
		service.delete(ID);
		verify(repository,times(1)).deleteById(anyInt());
		
		
	}
	private void startUser() {
		user= new User(ID, NAME, EMAIL, PASSWORD);
		
		user2=new User(ID, NAME2, EMAIL2, PASSWORD2);
		userDTO= new UserDTO(1, NAME, EMAIL, PASSWORD);
		optionalUser= Optional.of(new User(1, NAME, EMAIL, PASSWORD));
	}
	@Test
	void testFindByIdReturnObjectNotFoundException() {
		when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(EXCECAO));
		
		try {
			service.findById(ID);
		}
		catch(Exception ex) {
			assertEquals(ObjectNotFoundException.class, ex.getClass());
			assertEquals(EXCECAO,ex.getMessage());
		}
	}
	@Test
	void testUpdateIntegratyViolationException() {
		when(repository.findByEmail(anyString())).thenReturn(optionalUser);
		
		try {
			optionalUser.get().setId(2);
			service.create(userDTO);
			
		}      
		catch(Exception ex) {
			assertEquals(DataIntegratyViolationException.class,ex.getClass());
			assertEquals(EMAIL_JA_CADASTRADO,ex.getMessage());
			
		}
	
		
	}

}

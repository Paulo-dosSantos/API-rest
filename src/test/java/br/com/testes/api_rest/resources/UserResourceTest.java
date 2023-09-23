package br.com.testes.api_rest.resources;

import static org.junit.jupiter.api.Assertions.fail;

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
import br.com.testes.api_rest.services.impl.UserServiceImpl;

@SpringBootTest
class UserResourceTest {
	
	private static final String OBJETO_NÃO_ENCONTRADO = "Objeto não encontrado";

	private static final String EMAIL_JA_CADASTRADO = "Este e-mail já está cadastrado no sistema";

	private static final String EXCECAO = OBJETO_NÃO_ENCONTRADO;

	private static final String PASSWORD = "poscrise";

	private static final String EMAIL = "coringuete@gmail.com";

	private static final String NAME = "Bruce Wayne";

	private static final Integer ID = 1;
	
	private static final String NAME2 = "John Constantine";
	private static final String EMAIL2 = "constantine@gmail.com";
	private static final String PASSWORD2 = "vertigo@gmail.com";
	
	@InjectMocks
	private UserResource resource;
	
	@Mock
	private UserServiceImpl service;
	
	@Mock
	private ModelMapper mapper;
	
	private User user;
	private UserDTO userDTO;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	private void startUser() {
		user= new User(ID, NAME, EMAIL, PASSWORD);
		
		
		userDTO= new UserDTO(1, NAME, EMAIL, PASSWORD);
	}
		

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}

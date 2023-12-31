package br.com.testes.api_rest.resources.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import br.com.testes.api_rest.services.exceptions.ObjectNotFoundException;

@SpringBootTest
class ResourceExceptionHandlerTest {
	
	@InjectMocks
	private ResourceExceptionHandler exceptionHandler;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenObjectNotFoundExceptionThenReturnResponseEntity() {
		ResponseEntity<StandardError>response=exceptionHandler
				.objectNotFound(new ObjectNotFoundException("Objeto não encontrado")
						, new MockHttpServletRequest());
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
		assertEquals(ResponseEntity.class,response.getClass());
		assertEquals(StandardError.class,response.getBody().getClass());
		assertEquals("Objeto não encontrado",response.getBody().getError());
		assertEquals(404,response.getBody().getStatus());
	}

}

package br.com.pitang.appcarusers.adapters.web.in.users;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_ROUTE;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.RegisterUserUseCase;
import br.com.pitang.appcarusers.testdata.UserTestData;

@WebMvcTest(RegisterUserController.class)
class RegisterUserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RegisterUserUseCase useCase;

	@Test
	void testRegister() throws Exception {
		User user = UserTestData.getUser();
		user.setId(null);
		user.getCars().get(0).setId(null);
		
		when(useCase.register(user)).thenReturn(UserTestData.getUser());
		
		mockMvc.perform(MockMvcRequestBuilders.post(BASE_PATH + USERS_ROUTE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getUserJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private String getUserJsonMock() {
		return "{\r\n"
				+ "	\"firstName\": \"Vilma\",\r\n"
				+ "	\"lastName\": \"Souza\",\r\n"
				+ "	\"email\": \"vilma.souza@teste.com\",\r\n"
				+ "	\"birthday\": \"1994-01-02\",\r\n"
				+ "	\"login\": \"vilsou\",\r\n"
				+ "	\"password\": \"123321\",\r\n"
				+ "	\"phone\": \"8198877474\",\r\n"
				+ "	\"cars\": [\r\n"
				+ "		{\r\n"
				+ "			\"year\": 2001,\r\n"
				+ "			\"licensePlate\": \"PDV-2012\",\r\n"
				+ "			\"model\": \"peugeot\",\r\n"
				+ "			\"color\": \"blue\"\r\n"
				+ "		}\r\n"
				+ "	]\r\n"
				+ "}";
	}

}

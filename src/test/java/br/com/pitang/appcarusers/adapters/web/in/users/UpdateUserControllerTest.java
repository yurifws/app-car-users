package br.com.pitang.appcarusers.adapters.web.in.users;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_BY_ID_ROUTE;
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
import br.com.pitang.appcarusers.application.ports.in.UpdateUserUseCase;
import br.com.pitang.appcarusers.testdata.UserTestData;

@WebMvcTest(UpdateUserController.class)
class UpdateUserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UpdateUserUseCase useCase;
	@Test
	void testUpdate() throws Exception {
		User user = UserTestData.getUserUpdate();
		user.setId(null);
		user.getCars().get(0).setId(null);

		Long id = 1234l;
		
		when(useCase.update(user, id)).thenReturn(UserTestData.getUserUpdate());
		
		mockMvc.perform(MockMvcRequestBuilders.put(BASE_PATH + USERS_BY_ID_ROUTE, id)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getUserJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	private String getUserJsonMock() {
		return "{\r\n"
				+ "	\"firstName\": \"Silvana\",\r\n"
				+ "	\"lastName\": \"World\",\r\n"
				+ "	\"email\": \"silma.souza@teste.com\",\r\n"
				+ "	\"birthday\": \"1990-02-02\",\r\n"
				+ "	\"login\": \"silsou\",\r\n"
				+ "	\"password\": \"023321\",\r\n"
				+ "	\"phone\": \"8198877470\",\r\n"
				+ "	\"cars\": []\r\n"
				+ "}";
	}

}

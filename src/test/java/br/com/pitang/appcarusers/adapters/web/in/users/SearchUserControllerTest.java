package br.com.pitang.appcarusers.adapters.web.in.users;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_BY_ID_ROUTE;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.USERS_ROUTE;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import br.com.pitang.appcarusers.testdata.UserTestData;

@WebMvcTest(SearchUserController.class)
class SearchUserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SearchUserUseCase useCase;
	
	@Test
	void testSearch() throws Exception {
		List<User> users = new ArrayList<>();
		
		User user = UserTestData.getUser();
		user.setId(null);
		user.getCars().get(0).setId(null);
		users.add(user);
		
		when(useCase.searchAll()).thenReturn(users);
		
		mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + USERS_ROUTE)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testSearchById() throws Exception {

		Long id = 1234l;
		User user = UserTestData.getUser();
		
		when(useCase.searchById(id)).thenReturn(user);
		
		mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + USERS_BY_ID_ROUTE, id)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}

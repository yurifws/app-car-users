package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_BY_ID_ROUTE;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.pitang.appcarusers.ContextBaseTests;
import br.com.pitang.appcarusers.application.ports.in.RemoveCarUseCase;

@WebMvcTest(RemoveCarController.class)
class RemoveCarControllerTest extends ContextBaseTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RemoveCarUseCase useCase;

	@Test
	void testRemove() throws Exception {
		Long id = 123l;
		
		doNothing().when(useCase).removeById(id);
		
		mockMvc.perform(MockMvcRequestBuilders.delete(BASE_PATH + CARS_BY_ID_ROUTE, id)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}

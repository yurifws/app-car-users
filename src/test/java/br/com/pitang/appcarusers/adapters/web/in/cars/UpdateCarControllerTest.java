package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_BY_ID_ROUTE;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.pitang.appcarusers.ContextBaseTests;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.UpdateCarUseCase;
import br.com.pitang.appcarusers.testdata.CarTestData;

@WebMvcTest(UpdateCarController.class)
class UpdateCarControllerTest extends ContextBaseTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UpdateCarUseCase useCase;
	
	@Test
	void testUpdate() throws Exception {
		Car car = CarTestData.getCarUpdate();
		car.setId(null);

		Long id = 125L;
		
		when(useCase.update(car, id)).thenReturn(CarTestData.getCarUpdate());
		
		mockMvc.perform(MockMvcRequestBuilders.put(BASE_PATH + CARS_BY_ID_ROUTE, id)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getCarJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	private String getCarJsonMock() {
		return "		{\r\n"
				+ "			\"year\": 2002,\r\n"
				+ "			\"licensePlate\": \"PDV-2015\",\r\n"
				+ "			\"model\": \"audi\",\r\n"
				+ "			\"color\": \"white\"\r\n"
				+ "		}\r\n";
	}

}

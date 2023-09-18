package br.com.pitang.appcarusers.adapters.web.in.cars;

import static br.com.pitang.appcarusers.adapters.web.routes.Routes.BASE_PATH;
import static br.com.pitang.appcarusers.adapters.web.routes.Routes.CARS_ROUTE;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.RegisterCarUseCase;
import br.com.pitang.appcarusers.testdata.CarTestData;

@WebMvcTest(RegisterCarController.class)
class RegisterCarControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RegisterCarUseCase useCase;

	@Test
	void testRegister() throws Exception {
		Car car = CarTestData.getCar();
		car.setId(null);
		
		when(useCase.register(car)).thenReturn(CarTestData.getCar());
		
		mockMvc.perform(MockMvcRequestBuilders.post(BASE_PATH + CARS_ROUTE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getCarJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	private String getCarJsonMock() {
		return "		{\r\n"
				+ "			\"year\": 2001,\r\n"
				+ "			\"licensePlate\": \"PDV-2012\",\r\n"
				+ "			\"model\": \"peugeot\",\r\n"
				+ "			\"color\": \"blue\"\r\n"
				+ "		}\r\n";
	}

}

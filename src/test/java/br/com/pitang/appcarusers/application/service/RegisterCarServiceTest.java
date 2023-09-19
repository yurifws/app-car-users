package br.com.pitang.appcarusers.application.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.ValidateCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.RegisterCarPort;
import br.com.pitang.appcarusers.common.exception.LicensePlateAlreadyExistsException;
import br.com.pitang.appcarusers.testdata.CarTestData;

@ExtendWith(SpringExtension.class)
class RegisterCarServiceTest {
	
	@InjectMocks
	private RegisterCarService service;
	
	@Mock
	private RegisterCarPort port;

	@Mock
	private ValidateCarUseCase validateCarUseCase;

	@Test
	void testRegister() {
		
		Car car = CarTestData.getCar();
		car.setId(null);
		doNothing().when(validateCarUseCase).existsByLicensePlate(car.getLicensePlate());
		when(port.register(car)).thenReturn(CarTestData.getCar());
		
		Car response = service.register(car);
		
		verify(validateCarUseCase).existsByLicensePlate(car.getLicensePlate());
		verify(port).register(car);
		assertNotNull(response);
	}
	
	@Test
	void testRegister_LicensePlateAlreadyExistsException() {
		
		Car car = CarTestData.getCar();
		car.setId(null);
		doThrow(new LicensePlateAlreadyExistsException("")).when(validateCarUseCase).existsByLicensePlate(car.getLicensePlate());
		
		LicensePlateAlreadyExistsException exception = assertThrows(LicensePlateAlreadyExistsException.class, 
				() -> service.register(car));
		
		assertNotNull(exception);
		verify(validateCarUseCase, times(1)).existsByLicensePlate(car.getLicensePlate());
		verifyNoInteractions(port);
	}

}

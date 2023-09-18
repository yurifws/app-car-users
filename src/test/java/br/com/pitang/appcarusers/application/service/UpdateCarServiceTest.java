package br.com.pitang.appcarusers.application.service;

import static org.junit.Assert.assertNotNull;
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
import br.com.pitang.appcarusers.application.ports.out.UpdateCarPort;
import br.com.pitang.appcarusers.common.exception.LicensePlateAlreadyExistsException;
import br.com.pitang.appcarusers.testdata.CarTestData;

@ExtendWith(SpringExtension.class)
class UpdateCarServiceTest {
	
	@InjectMocks
	private UpdateCarService service;

	@Mock
	private UpdateCarPort port;
	
	@Mock
	private ValidateCarUseCase validateCarUseCase;

	@Test
	void testUpdate() {
		
		Car car = CarTestData.getCar();
		car.setId(null);
		Long id = 1234l;
		doNothing().when(validateCarUseCase).existsByLicensePlate(car.getLicensePlate());
		when(port.update(car, id)).thenReturn(CarTestData.getCar());
		
		Car response = service.update(car, id);
		
		verify(validateCarUseCase).existsByLicensePlate(car.getLicensePlate());
		verify(port).update(car, id);
		assertNotNull(response);
	}

	@Test
	void testUpdate_LicensePlateAlreadyExistsException() {
		
		Car car = CarTestData.getCar();
		car.setId(null);
		Long id = 1234l;
		doNothing().when(validateCarUseCase).existsByLicensePlate(car.getLicensePlate());
		doThrow(new LicensePlateAlreadyExistsException("")).when(validateCarUseCase).existsByLicensePlate(car.getLicensePlate());
		
		LicensePlateAlreadyExistsException exception = assertThrows(LicensePlateAlreadyExistsException.class, 
				() -> service.update(car, id));
		
		assertNotNull(exception);
		verify(validateCarUseCase, times(1)).existsByLicensePlate(car.getLicensePlate());
		verifyNoInteractions(port);
	}

}

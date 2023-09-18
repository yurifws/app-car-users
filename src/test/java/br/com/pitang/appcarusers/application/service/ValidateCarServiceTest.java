package br.com.pitang.appcarusers.application.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.pitang.appcarusers.application.ports.out.ValidateCarPort;
import br.com.pitang.appcarusers.common.exception.LicensePlateAlreadyExistsException;

@ExtendWith(SpringExtension.class)
class ValidateCarServiceTest {
	
	@InjectMocks
	private ValidateCarService service;
	
	@Mock
	private ValidateCarPort port;

	@Test
	void testExistsByEmail() {
		
		String licensePlate = "PDV-2010";
		when(port.existsByLicensePlate(licensePlate)).thenReturn(false);
		
		service.existsByLicensePlate(licensePlate);

		verify(port).existsByLicensePlate(licensePlate);
		
	}
	
	@Test
	void testExistsByEmail_EmailAlreadyExistsException() {
		
		String licensePlate = "PDV-2010";
		when(port.existsByLicensePlate(licensePlate)).thenReturn(true);
		
		;
		LicensePlateAlreadyExistsException exception = assertThrows(LicensePlateAlreadyExistsException.class, 
				() -> service.existsByLicensePlate(licensePlate));

		verify(port).existsByLicensePlate(licensePlate);
		assertNotNull(exception);

	}

}

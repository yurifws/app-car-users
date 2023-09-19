package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.ports.in.ValidateCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.ValidateCarPort;
import br.com.pitang.appcarusers.common.exception.LicensePlateAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ValidateCarService implements ValidateCarUseCase {
	
	private final ValidateCarPort port;
	
	@Override
	public void existsByLicensePlate(String licensePlate) {
		if(port.existsByLicensePlate(licensePlate)) {
			throw new LicensePlateAlreadyExistsException("License plate already exists");
		}
	}

}

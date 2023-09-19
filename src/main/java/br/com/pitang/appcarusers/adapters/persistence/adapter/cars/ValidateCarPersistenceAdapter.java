package br.com.pitang.appcarusers.adapters.persistence.adapter.cars;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.adapters.persistence.service.cars.ICarService;
import br.com.pitang.appcarusers.application.ports.out.ValidateCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ValidateCarPersistenceAdapter implements ValidateCarPort {

	private final ICarService service;
	
	@Override
	public boolean existsByLicensePlate(String licensePlate) {
		return service.existsByLicensePlate(licensePlate);
	}

}

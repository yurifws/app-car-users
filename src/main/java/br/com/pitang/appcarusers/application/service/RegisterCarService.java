package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.RegisterCarUseCase;
import br.com.pitang.appcarusers.application.ports.in.ValidateCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.RegisterCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegisterCarService implements RegisterCarUseCase {

	private final RegisterCarPort port;
	private final ValidateCarUseCase validateCarUseCase;
	
	@Override
	public Car register(Car car) {
		validateCarUseCase.existsByLicensePlate(car.getLicensePlate());
		return port.register(car);
	}
	
}

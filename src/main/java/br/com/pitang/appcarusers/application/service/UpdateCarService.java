package br.com.pitang.appcarusers.application.service;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import br.com.pitang.appcarusers.application.ports.in.UpdateCarUseCase;
import br.com.pitang.appcarusers.application.ports.in.ValidateCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.UpdateCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateCarService implements UpdateCarUseCase {

	private final UpdateCarPort port;
	private final ValidateCarUseCase validateCarUseCase;
	private final SearchUserUseCase searchUserUseCase;
	
	@Override
	public Car update(Car car, Long id) {
		validateCarUseCase.existsByLicensePlate(car.getLicensePlate());
		car.setUser(searchUserUseCase.searchByLoggedUser());
		return port.update(car, id);
	}

}

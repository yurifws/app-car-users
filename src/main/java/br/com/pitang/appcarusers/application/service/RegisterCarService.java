package br.com.pitang.appcarusers.application.service;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.RegisterCarUseCase;
import br.com.pitang.appcarusers.application.ports.in.SearchUserUseCase;
import br.com.pitang.appcarusers.application.ports.in.ValidateCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.RegisterCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegisterCarService implements RegisterCarUseCase {

	private final RegisterCarPort port;
	private final ValidateCarUseCase validateCarUseCase;
	private final SearchUserUseCase searchUserUseCase;
	
	@Override
	public Car register(Car car) {
		validateCarUseCase.existsByLicensePlate(car.getLicensePlate());
		if(ObjectUtils.isEmpty(car.getUser())) {
			car.setUser(searchUserUseCase.searchByLoggedUser());
		}
		return port.register(car);
	}
	
}

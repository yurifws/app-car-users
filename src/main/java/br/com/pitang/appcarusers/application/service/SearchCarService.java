package br.com.pitang.appcarusers.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.ports.in.SearchCarUseCase;
import br.com.pitang.appcarusers.application.ports.out.SearchCarPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SearchCarService implements SearchCarUseCase {

	private final SearchCarPort port;
	private final SearchUserService searchUserService;
	
	@Override
	public List<Car> searchAllByUserId() {
		return port.searchAllByUserId(searchUserService.searchByLoggedUser().getId());
	}

	@Override
	public Car searchById(Long id) {
		Optional<Car> optionalCar = port.searchByIdAndUserId(id, searchUserService.searchByLoggedUser().getId());
		if(optionalCar.isPresent()) {
			return optionalCar.get();
		}
		return null;
	}
}

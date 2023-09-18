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
	
	@Override
	public List<Car> searchAll() {
		return port.searchAll();
	}

	@Override
	public Car searchById(Long id) {
		Optional<Car> optionalCar = port.searchById(id);
		if(optionalCar.isPresent()) {
			return optionalCar.get();
		}
		return null;
	}
}

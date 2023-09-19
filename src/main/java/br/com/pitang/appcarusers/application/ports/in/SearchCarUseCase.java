package br.com.pitang.appcarusers.application.ports.in;

import java.util.List;

import br.com.pitang.appcarusers.application.domain.cars.Car;

public interface SearchCarUseCase {

	List<Car> searchAllByUserId();
	Car searchById(Long id);
}

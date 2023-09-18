package br.com.pitang.appcarusers.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.pitang.appcarusers.application.domain.cars.Car;

public interface SearchCarPort {

	List<Car> searchAll();
	Optional<Car> searchById(Long id);
}

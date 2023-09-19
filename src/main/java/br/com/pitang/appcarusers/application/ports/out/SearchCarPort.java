package br.com.pitang.appcarusers.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.pitang.appcarusers.application.domain.cars.Car;

public interface SearchCarPort {
	
	List<Car> searchAllByUserId(Long userId);
	Optional<Car> searchByIdAndUserId(Long id, Long userId);
}

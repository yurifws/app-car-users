package br.com.pitang.appcarusers.adapters.persistence.service.cars;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.repository.CarRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CarService implements ICarService {

	private final CarRepository repository;

	@Transactional
	@Override
	public CarEntity save(CarEntity carEntity) {
		return repository.save(carEntity);
	}

	@Override
	public List<CarEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<CarEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	@Override
	public void removeById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existsByLicensePlate(String licensePlate) {
		return repository.existsByLicensePlate(licensePlate);
	}

	@Override
	public List<CarEntity> findAllByUserId(Long userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public Optional<CarEntity> findByIdAndUserId(Long id, Long userId) {
		return repository.findByIdAndUserId(id, userId);
	}

}

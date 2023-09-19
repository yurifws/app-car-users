package br.com.pitang.appcarusers.adapters.persistence.service.cars;

import java.util.List;
import java.util.Optional;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;

public interface ICarService {
	
	CarEntity save(CarEntity userEntity);
	List<CarEntity> findAll();
	Optional<CarEntity> findById(Long id);  
	void removeById(Long id);
	boolean existsByLicensePlate(String licensePlate);
	List<CarEntity> findAllByUserId(Long userId);
	Optional<CarEntity> findByIdAndUserId(Long id, Long userId);
}
 
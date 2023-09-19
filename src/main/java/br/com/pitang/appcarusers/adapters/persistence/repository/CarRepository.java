package br.com.pitang.appcarusers.adapters.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;


public interface CarRepository  extends JpaRepository<CarEntity, Long>{

	boolean existsByLicensePlate(String licensePlate);
	List<CarEntity> findByUserId(Long userId);
	Optional<CarEntity> findByIdAndUserId(Long id, Long userId);

}

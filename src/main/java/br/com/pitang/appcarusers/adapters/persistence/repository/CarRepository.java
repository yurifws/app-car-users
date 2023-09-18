package br.com.pitang.appcarusers.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;

public interface CarRepository  extends JpaRepository<CarEntity, Long>{

	boolean existsByLicensePlate(String licensePlate);

}

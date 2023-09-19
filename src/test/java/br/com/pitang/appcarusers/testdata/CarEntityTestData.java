package br.com.pitang.appcarusers.testdata;

import java.util.Optional;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;

public class CarEntityTestData {
	
	public static Optional<CarEntity> getOptionalCarEntity(){
		return Optional.of(getCarEntity());
	}
	
	public static Optional<CarEntity> getOptionalCarEntityByUser(){
		return Optional.of(getCarEntityByUser());
	}
	
	public static CarEntity getCarEntityByUser() {
		return CarEntity.builder()
				.id(123L)
				.year(2001)
				.licensePlate("PDV-2012")
				.model("peugeot")
				.color("blue")
				.user(UserEntityTestData.getUserEntity())
				.build();
	}

	public static CarEntity getCarEntity() {
		return CarEntity.builder()
				.id(123L)
				.year(2001)
				.licensePlate("PDV-2012")
				.model("peugeot")
				.color("blue")
				.build();
	}
	
	public static CarEntity getCarEntityUpdate() {
		return CarEntity.builder()
				.id(123L)
				.year(2002)
				.licensePlate("PDV-2015")
				.model("audi")
				.color("white")
				.build();
	}
}

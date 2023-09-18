package br.com.pitang.appcarusers.testdata;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;

public class CarEntityTestData {

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
				.id(125L)
				.year(2002)
				.licensePlate("PDV-2015")
				.model("audi")
				.color("white")
				.build();
	}
}

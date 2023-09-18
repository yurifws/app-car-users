package br.com.pitang.appcarusers.testdata;

import br.com.pitang.appcarusers.application.domain.cars.Car;

public class CarTestData {

	public static Car getCar() {
		return Car.builder()
				.id(123L)
				.year(2001)
				.licensePlate("PDV-2012")
				.model("peugeot")
				.color("blue")
				.build();
	}
	
	public static Car getCarUpdate() {
		return Car.builder()
				.id(125L)
				.year(2002)
				.licensePlate("PDV-2015")
				.model("audi")
				.color("white")
				.build();
	}
}

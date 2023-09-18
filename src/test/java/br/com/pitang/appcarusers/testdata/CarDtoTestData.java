package br.com.pitang.appcarusers.testdata;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarDto;

public class CarDtoTestData {

	public static CarDto getCarDto() {
		return CarDto.builder()
				.year(2001)
				.licensePlate("PDV-2012")
				.model("peugeot")
				.color("blue")
				.build();
	}

}

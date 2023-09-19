package br.com.pitang.appcarusers.testdata;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarRequestDto;

public class CarDtoTestData {

	public static CarRequestDto getCarDto() {
		return CarRequestDto.builder()
				.year(2001)
				.licensePlate("PDV-2012")
				.model("peugeot")
				.color("blue")
				.build();
	}

}

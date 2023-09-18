package br.com.pitang.appcarusers.testdata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarDto;
import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserDto;

public class UserDtoTestData {
	

	public static Optional<UserDto> getOptionalUserDto() {
		return Optional.of(getUserDto());
	}

	public static UserDto getUserDto() {
		List<CarDto> cars = new ArrayList<>();
		cars.add(CarDtoTestData.getCarDto());
		
		return UserDto.builder()
				.firstName("Vilma")
				.lastName("Souza")
				.email("vilma.souza@teste.com")
				.birthday(LocalDate.of(1994, 01, 02))
				.login("vilsou")
				.password("123321")
				.phone("8198877474")
				.cars(cars)
				.build();
	}

}

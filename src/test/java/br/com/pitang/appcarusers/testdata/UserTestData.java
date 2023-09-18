package br.com.pitang.appcarusers.testdata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.domain.users.User;

public class UserTestData {

	public static User getUser() {
		List<Car> cars = new ArrayList<>();
		cars.add(CarTestData.getCar());
		
		return User.builder()
				.id(1234l)
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
	
	public static User getUserUpdate() {
		List<Car> cars = new ArrayList<>();
		cars.add(CarTestData.getCarUpdate());
		
		return User.builder()
				.id(1234l)
				.firstName("Silvana")
				.lastName("Souza")
				.email("silma.souza@teste.com")
				.birthday(LocalDate.of(1994, 02, 02))
				.login("silsou")
				.password("023321")
				.phone("8198877470")
				.cars(cars)
				.build();
	}
}

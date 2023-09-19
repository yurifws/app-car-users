package br.com.pitang.appcarusers.testdata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;

public class UserEntityTestData {
	
	public static Optional<UserEntity> getOptionalUserEntity(){
		return Optional.of(getUserEntity());
	}

	public static UserEntity getUserEntity() {
		List<CarEntity> cars = new ArrayList<>();
		cars.add(CarEntityTestData.getCarEntity());
		
		return UserEntity.builder()
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
	
	public static UserEntity getUserEntityUpdate() {
		List<CarEntity> cars = new ArrayList<>();
		cars.add(CarEntityTestData.getCarEntityUpdate());
		
		return UserEntity.builder()
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

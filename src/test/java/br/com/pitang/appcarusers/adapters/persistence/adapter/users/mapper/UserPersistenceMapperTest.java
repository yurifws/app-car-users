package br.com.pitang.appcarusers.adapters.persistence.adapter.users.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.pitang.appcarusers.adapters.persistence.entity.CarEntity;
import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.testdata.UserEntityTestData;
import br.com.pitang.appcarusers.testdata.UserTestData;

class UserPersistenceMapperTest {
	
	UserPersistenceMapper mapper = UserPersistenceMapper.INSTANCE;
	
	
	@Test
	void testToUserEntity() {
		User user = UserTestData.getUser();

		UserEntity userEntity = mapper.toUserEntity(user);
		
		assertNotNull(userEntity);
		assertEquals(user.getId(), userEntity.getId());
		assertEquals(user.getFirstName(), userEntity.getFirstName());
		assertEquals(user.getLastName(), userEntity.getLastName());
		assertEquals(user.getEmail(), userEntity.getEmail());
		assertEquals(user.getBirthday(), userEntity.getBirthday());
		assertEquals(user.getLogin(), userEntity.getLogin());
		assertEquals(user.getPassword(), userEntity.getPassword());
		assertEquals(user.getPhone(), userEntity.getPhone());

		Car carEntity = user.getCars().get(0);
		CarEntity car = userEntity.getCars().get(0);
		assertEquals(car.getId(), carEntity.getId());
		assertEquals(car.getYear(), carEntity.getYear());
		assertEquals(car.getLicensePlate(), carEntity.getLicensePlate());
		assertEquals(car.getModel(), carEntity.getModel());
		assertEquals(car.getColor(), carEntity.getColor());
		
	}
	
	@Test
	void testToUser() {
		UserEntity userEntity = UserEntityTestData.getUserEntity();

		User user = mapper.toUser(userEntity);

		assertNotNull(user);
		assertEquals(userEntity.getId(), user.getId());
		assertEquals(userEntity.getFirstName(), user.getFirstName());
		assertEquals(userEntity.getLastName(), user.getLastName());
		assertEquals(userEntity.getEmail(), user.getEmail());
		assertEquals(userEntity.getBirthday(), user.getBirthday());
		assertEquals(userEntity.getLogin(), user.getLogin());
		assertEquals(userEntity.getPassword(), user.getPassword());
		assertEquals(userEntity.getPhone(), user.getPhone());

		CarEntity carEntity = userEntity.getCars().get(0);
		Car car = user.getCars().get(0);
		assertEquals(carEntity.getId(), car.getId());
		assertEquals(carEntity.getYear(), car.getYear());
		assertEquals(carEntity.getLicensePlate(), car.getLicensePlate());
		assertEquals(carEntity.getModel(), car.getModel());
		assertEquals(carEntity.getColor(), car.getColor());
		
	}
	
	@Test
	void testToUsers() {
		List<UserEntity> userEntities = new ArrayList<>();
		userEntities.add(UserEntityTestData.getUserEntity());

		List<User> users = mapper.toUsers(userEntities);

		UserEntity userEntity = userEntities.get(0);
		User user = users.get(0);
		assertNotNull(users);
		assertEquals(userEntity.getId(), user.getId());
		assertEquals(userEntity.getFirstName(), user.getFirstName());
		assertEquals(userEntity.getLastName(), user.getLastName());
		assertEquals(userEntity.getEmail(), user.getEmail());
		assertEquals(userEntity.getBirthday(), user.getBirthday());
		assertEquals(userEntity.getLogin(), user.getLogin());
		assertEquals(userEntity.getPassword(), user.getPassword());
		assertEquals(userEntity.getPhone(), user.getPhone());

		CarEntity carEntity = userEntity.getCars().get(0);
		Car car = user.getCars().get(0);
		assertEquals(carEntity.getId(), car.getId());
		assertEquals(carEntity.getYear(), car.getYear());
		assertEquals(carEntity.getLicensePlate(), car.getLicensePlate());
		assertEquals(carEntity.getModel(), car.getModel());
		assertEquals(carEntity.getColor(), car.getColor());
		
	}
	
	@Test
	void testUpdate() {
		UserEntity userEntity = UserEntityTestData.getUserEntity();
		User user = UserTestData.getUserUpdate();
		
		mapper.update(userEntity, user);
		
		assertNotNull(user);
		assertEquals(userEntity.getId(), user.getId());
		assertEquals(userEntity.getFirstName(), user.getFirstName());
		assertEquals(userEntity.getLastName(), user.getLastName());
		assertEquals(userEntity.getEmail(), user.getEmail());
		assertEquals(userEntity.getBirthday(), user.getBirthday());
		assertEquals(userEntity.getLogin(), user.getLogin());
		assertEquals(userEntity.getPassword(), user.getPassword());
		assertEquals(userEntity.getPhone(), user.getPhone());

		CarEntity carEntity = userEntity.getCars().get(0);
		Car car = user.getCars().get(0);
		assertEquals(carEntity.getId(), car.getId());
		assertEquals(carEntity.getYear(), car.getYear());
		assertEquals(carEntity.getLicensePlate(), car.getLicensePlate());
		assertEquals(carEntity.getModel(), car.getModel());
		assertEquals(carEntity.getColor(), car.getColor());
		
	}


}

package br.com.pitang.appcarusers.adapters.web.in.users.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.pitang.appcarusers.adapters.web.in.cars.dto.CarRequestDto;
import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserRequestDto;
import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserResponseDto;
import br.com.pitang.appcarusers.application.domain.cars.Car;
import br.com.pitang.appcarusers.application.domain.users.User;
import br.com.pitang.appcarusers.testdata.UserDtoTestData;
import br.com.pitang.appcarusers.testdata.UserTestData;

class UserControllerMapperTest {
	
	UserControllerMapper mapper = UserControllerMapper.INSTANCE;

	@Test
	void testToUser() {
		
		UserRequestDto userDto = UserDtoTestData.getUserDto();
		User user = mapper.toUser(userDto);
		
		assertNotNull(user);
		assertEquals(userDto.getFirstName(), user.getFirstName());
		assertEquals(userDto.getLastName(), user.getLastName());
		assertEquals(userDto.getEmail(), user.getEmail());
		assertEquals(userDto.getBirthday(), user.getBirthday());
		assertEquals(userDto.getLogin(), user.getLogin());
		assertEquals(userDto.getPassword(), user.getPassword());
		assertEquals(userDto.getPhone(), user.getPhone());

		CarRequestDto carDto = userDto.getCars().get(0);
		Car car = user.getCars().get(0);
		assertEquals(carDto.getYear(), car.getYear());
		assertEquals(carDto.getLicensePlate(), car.getLicensePlate());
		assertEquals(carDto.getModel(), car.getModel());
		assertEquals(carDto.getColor(), car.getColor());
	}
	

	@Test
	void testToUserDto() {
		
		User user = UserTestData.getUser();
		UserResponseDto userResponseDto = mapper.toUserResponseDto(user);
		
		assertNotNull(userResponseDto);
		assertEquals(user.getFirstName(), userResponseDto.getFirstName());
		assertEquals(user.getLastName(), userResponseDto.getLastName());
		assertEquals(user.getEmail(), userResponseDto.getEmail());
		assertEquals(user.getBirthday(), userResponseDto.getBirthday());
		assertEquals(user.getLogin(), userResponseDto.getLogin());
		assertEquals(user.getPassword(), userResponseDto.getPassword());
		assertEquals(user.getPhone(), userResponseDto.getPhone());

	}
	
	@Test
	void testToUsersDto() {
		List<User> users = new ArrayList<>();
		users.add(UserTestData.getUser());
		List<UserResponseDto> usersResponseDto = mapper.toUsersResponseDtoDto(users);
		

		User user = users.get(0);
		UserResponseDto userResponseDto = usersResponseDto.get(0);
		
		assertNotNull(userResponseDto);
		assertEquals(user.getFirstName(), userResponseDto.getFirstName());
		assertEquals(user.getLastName(), userResponseDto.getLastName());
		assertEquals(user.getEmail(), userResponseDto.getEmail());
		assertEquals(user.getBirthday(), userResponseDto.getBirthday());
		assertEquals(user.getLogin(), userResponseDto.getLogin());
		assertEquals(user.getPassword(), userResponseDto.getPassword());
		assertEquals(user.getPhone(), userResponseDto.getPhone());
		
	}

}

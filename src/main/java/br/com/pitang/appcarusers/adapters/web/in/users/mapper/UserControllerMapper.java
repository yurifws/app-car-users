package br.com.pitang.appcarusers.adapters.web.in.users.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserDto;
import br.com.pitang.appcarusers.application.domain.users.User;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserControllerMapper {

	UserControllerMapper INSTANCE = Mappers.getMapper(UserControllerMapper.class);

	public User toUser(UserDto userDto);
	public UserDto toUserDto(User user);

	public List<UserDto> toUsersDto(List<User> users);
}

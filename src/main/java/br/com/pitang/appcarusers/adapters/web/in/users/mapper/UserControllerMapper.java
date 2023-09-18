package br.com.pitang.appcarusers.adapters.web.in.users.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.pitang.appcarusers.adapters.web.in.users.dto.UserRequestDto;
import br.com.pitang.appcarusers.application.domain.users.User;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UserControllerMapper {

	UserControllerMapper INSTANCE = Mappers.getMapper(UserControllerMapper.class);

	public User toUser(UserRequestDto userDto);
	public UserRequestDto toUserDto(User user);

	public List<UserRequestDto> toUsersDto(List<User> users);
}

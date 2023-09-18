package br.com.pitang.appcarusers.adapters.persistence.adapter.users.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.application.domain.users.User;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UserPersistenceMapper {
	
	UserPersistenceMapper INSTANCE = Mappers.getMapper(UserPersistenceMapper.class);

	public UserEntity toUserEntity(User user);
	public User toUser(UserEntity userEntity);

	public List<User> toUsers(List<UserEntity> userEntities);

	@Mapping(target = "id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void update(@MappingTarget UserEntity userEntity, User user);

}

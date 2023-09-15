package br.com.pitang.appcarusers.adapters.persistence.service.users;

import java.util.List;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.common.exception.UserNotFoundException;

public interface IUserService {
	
	UserEntity save(UserEntity userEntity);
	List<UserEntity> findAll();
	UserEntity findById(Long id) throws UserNotFoundException;  
	void removeById(Long id);
}
 
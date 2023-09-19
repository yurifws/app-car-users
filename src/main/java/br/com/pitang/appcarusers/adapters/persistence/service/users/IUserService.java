package br.com.pitang.appcarusers.adapters.persistence.service.users;

import java.util.List;
import java.util.Optional;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;

public interface IUserService {
	
	UserEntity save(UserEntity userEntity);
	List<UserEntity> findAll();
	Optional<UserEntity> findById(Long id);  
	void removeById(Long id);
	boolean existsByEmail(String email);
	boolean existsByLogin(String login);
	UserEntity findByLogin(String login);
}
 
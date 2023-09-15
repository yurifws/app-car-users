package br.com.pitang.appcarusers.adapters.persistence.service.users;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.persistence.repository.UserRepository;
import br.com.pitang.appcarusers.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {
	
	private final UserRepository repository;

	@Transactional
	@Override
	public UserEntity save(UserEntity userEntity) {
		return repository.save(userEntity);
	}

	@Override
	public List<UserEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public UserEntity findById(Long id) throws UserNotFoundException {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Transactional
	@Override
	public void removeById(Long id) {
		repository.deleteById(id);
	}

}

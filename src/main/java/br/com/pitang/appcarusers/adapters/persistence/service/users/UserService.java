package br.com.pitang.appcarusers.adapters.persistence.service.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;
import br.com.pitang.appcarusers.adapters.persistence.repository.UserRepository;
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
	public Optional<UserEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	@Override
	public void removeById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}

	@Override
	public boolean existsByLogin(String login) {
		return repository.existsByLogin(login);
	}

	@Override
	public UserEntity findByLogin(String login) {
		return repository.findByLogin(login);
	}

}

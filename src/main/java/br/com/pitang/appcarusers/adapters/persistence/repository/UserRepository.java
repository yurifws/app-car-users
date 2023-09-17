package br.com.pitang.appcarusers.adapters.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pitang.appcarusers.adapters.persistence.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	boolean existsByEmail(String email);
	boolean existsByLogin(String login);
}

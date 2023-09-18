package br.com.pitang.appcarusers.application.ports.out;

public interface ValidateUserPort {

	boolean existsByEmail(String email);
	boolean existsByLogin(String login);
}
